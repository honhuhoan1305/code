import java.util.HashSet;
import java.util.PriorityQueue;

public class AStarSearchAlgo implements IInformedSearchAlgo {

    @Override
    public Node execute(Node root, String goal) {
        return execute(root, root.getLabel(), goal);
    }

    @Override
    public Node execute(Node root, String start, String goal) {
        if (root == null || start == null || goal == null) {
            return null;
        }

        PriorityQueue<Node> frontier = new PriorityQueue<>();
        HashSet<Node> explored = new HashSet<>();

        frontier.add(root);

        while (!frontier.isEmpty()) {
            Node current = frontier.poll();

            if (current.getLabel().equals(goal)) {
                return current; // Goal node found
            }

            explored.add(current);

            for (Node neighbor : current.getChildrenNodes()) {
                if (explored.contains(neighbor)) {
                    continue; // Skip nodes in the explored set
                }

                double tentativeG = current.getG() + current.getEdgeTo(neighbor).getWeight();
                if (!frontier.contains(neighbor) || tentativeG < neighbor.getG()) {
                    neighbor.setParent(current);
                    neighbor.setG(tentativeG);

                    if (!frontier.contains(neighbor)) {
                        frontier.add(neighbor);
                    }
                }
            }
        }

        return null; // No path to the goal
    }
}
