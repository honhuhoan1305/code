import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class GreedyBestFirstSearchAlgo implements IInformedSearchAlgo {

    @Override
    public Node execute(Node root, String goal) {
        return execute(root, root.getLabel(), goal);
    }

    @Override
    public Node execute(Node root, String start, String goal) {
        if (root == null || start == null || goal == null) {
            return null;
        }

        PriorityQueue<Node> openSet = new PriorityQueue<>(Comparator.comparingDouble(node -> node.getH())); // tạoPriorityQueue sắp sếp theo H (hurueic
        HashSet<Node> closedSet = new HashSet<>();
        openSet.add(root); // thêm root vào hashset
        while (!openSet.isEmpty()) { // nếuopenSet còn thì lặp
            Node current = openSet.poll(); // lấy ra
            if (current.getLabel().equals(goal)) {
                return current; // nếu nó là goal thì trả về
            }
            closedSet.add(current); // k phải thì thêm vào hashset

            for (Node neighbor : current.getChildrenNodes()) { // duyệt qua các phần tử con của curent
                if (closedSet.contains(neighbor)) { // nếu phần tu con đã tồn tại trong hashset
                    continue;
                }
                double tentativeG = current.getG() + current.getEdgeTo(neighbor).getWeight();
                if (!openSet.contains(neighbor) || tentativeG < neighbor.getG()) {
                    neighbor.setParent(current);
                    neighbor.setG(tentativeG);
                    if (!openSet.contains(neighbor)) {
                        openSet.add(neighbor);
                    }
                }
            }
        }
        return null;
    }
}
