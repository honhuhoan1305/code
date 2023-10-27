import java.util.Comparator;

public class NodeComparatorByCost implements Comparator<Node> {
    @Override
    public int compare(Node node1, Node node2) {
        double cost1 = node1.getG() + node1.getH();
        double cost2 = node2.getG() + node2.getH();
        return Double.compare(cost1, cost2);
    }
}
