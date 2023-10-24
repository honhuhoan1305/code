package bt2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class BreadthFirstSearchAlgo implements ISearchAlgo {

    @Override
    public Node execute(Node root, String goal) {// tìm đường đi từ nút gốc tới goal
        Queue<Node> feateer = new LinkedList<>();
        feateer.add(root); // thêm node vào hàng đợi
        List<Node> explored = new ArrayList<>(); // tạo danh sách
        while (!feateer.isEmpty()) { // nếu hàng đợi còn thì lặp...
         Node current =   feateer.poll();  // lấy node ở đầu hàng đợi ra
         if(current.getLabel().equals(goal)) return current; // nếu nó là goal thì trả về node đó
         else {
         explored.add(current);  // nếu không phải thì thêm node đó vào danh sách explored
         List<Node> children = current.getChildrenNodes(); // tạo danh sách gồm các node con của node vừa lấy
         for(Node child:children) {   // duyệt qua từng node con
             if(!feateer.contains(child) && !explored.contains(child)){  // nneu node con chưa có trong danh sasch hoặc trong hàng đợi
                 feateer.add(child);  // thêm node con đó vào hàng đợi
                 child.setParent(current);  //  in ra đường đi đến nó
             }
         }
        }
        }
        return null;
    }

    @Override
    public Node execute(Node root, String start, String goal) {
        Queue<Node> frontier = new LinkedList<>();
        frontier.add(root); // Thêm nút gốc vào hàng đợi
        List<Node> explored = new ArrayList<>(); // Tạo danh sách các nút đã được duyệt qua

        while (!frontier.isEmpty()) {
            Node current = frontier.poll(); // Lấy nút ở đầu hàng đợi ra
            if(current.getLabel().equals(start)) {  // đến khi nó là nút start thì reset lại hết, xem như start là gốc
                frontier.clear();
                explored.clear();
                current.setParent(null);
            }
            if (current.getLabel().equals(goal)) {
                return current; // Nếu nút hiện tại là mục tiêu, trả về nút đó
            } else {
                explored.add(current); // Nếu không phải, thêm nút hiện tại vào danh sách đã duyệt
                List<Node> children = current.getChildrenNodes(); // Lấy danh sách các nút con của nút hiện tại

                for (Node child : children) {
                    if (!frontier.contains(child) && !explored.contains(child)) {
                        frontier.add(child); // Thêm nút con vào hàng đợi nếu chưa được duyệt qua
                        child.setParent(current); // Ghi nhận đường đi từ nút gốc đến nút con
                    }
                }
            }
        }
        return null; // Nếu không tìm thấy đường đi, trả về null
    }


}
