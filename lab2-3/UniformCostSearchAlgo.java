package bt2;

import java.util.*;

public class UniformCostSearchAlgo implements ISearchAlgo {
    @Override
    public Node execute(Node root, String start, String goal) {
        return null;
    }

    @Override
    public Node execute(Node root, String goal) {
        PriorityQueue<Node> frontier = new PriorityQueue<>(Comparator.comparing(Node::getPathCost));
        Set<Node> explored = new HashSet<>();
        root.setPathCost(0);// set nút gsc chi phí là 0
        frontier.add(root); // thêm vào hàng đợi

        while (!frontier.isEmpty()) { // nếu hàng đợi còn thì lấy ra
            Node current = frontier.poll();  // lấy ra

            if (current.getLabel().equals(goal)) { // nếu nó là goal thì trả về nút đó
                return current;
            }

            explored.add(current); // thêm nút vừa lấy ra vào hashset

            List<Edge> children = current.getChildren(); // lấy ra toàn bộ nust con của nút vừa đưa vào hashset

            for (Edge childEdge : children) {
                Node child = childEdge.getEnd(); // duyệt qua từng nút đích
                double newCost = current.getPathCost() + childEdge.getWeight(); // chi phí = chi phí đi đến curent + chi phí từ current đến child

                if (!explored.contains(child) && !frontier.contains(child)) { // nếu trong hashset chưa có nút child và trong hàng đợi cũng chưa có child thì ..
                    child.setPathCost(newCost);  // gán chi phí đường đi từ gốc -> chil = newCost
                    child.setParent(current);  // set lại đường đi
                    frontier.add(child);  // thêm chil vào trong hàng đợi
                } else if (frontier.contains(child) && newCost < child.getPathCost()) {
                    // Nếu nút con đã nằm trong hàng đợi và có chi phí mới thấp hơn, cập nhật nó
                    child.setPathCost(newCost);
                    child.setParent(current);
                }
            }
        }
        return null;
    }
}