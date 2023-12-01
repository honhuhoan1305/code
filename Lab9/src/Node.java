import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Node {
	private List<Integer> data = new ArrayList<Integer>();

	public void add(Integer val) {
		this.data.add(val);
	}

	public void addAll(List<Integer> data) {
		this.data.addAll(data);
	}

	public List<Node> getSuccessors() {
		List<Node> successors = new ArrayList<>();
		for (int i = 0; i < this.data.size(); i++) {
			for (int j = 1; j < this.data.get(i); j++) {
				List<Integer> successorData = new ArrayList<>(this.data);
				successorData.set(i, j);
				successorData.add(this.data.get(i) - j);
				Node successor = new Node();
				successor.addAll(successorData);
				if (!successors.contains(successor)) {
					successors.add(successor);
				}
			}
		}
		return successors;
	}

	public boolean isTerminal() {
		for (int pile : this.data) {
			if (pile > 1) {
				return false;
			}
		}
		return true;
	}

	public int evaluate() {
		if (isTerminal()) {
			// max thắng trả về 1
			return 1;
		} else {
			// min thắng trả về 0
			return 0;
		}
	}

	public static final Comparator<Integer> DESCOMPARATOR = new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	};

	@Override
	public String toString() {
		Collections.sort(this.data, DESCOMPARATOR);
		return this.data.toString();
	}
}
