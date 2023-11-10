import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        testNQueens();
    }
    //test

    public static void testNQueens() {
        Node initialNode = new Node();
        System.out.println("Initial State:");
        initialNode.displayBoard();
        System.out.println("Initial Heuristic: " + initialNode.getH());

        System.out.println("\nRunning Genetic Algorithm:");
        geneticAlgorithm(initialNode);
    }

    public static void geneticAlgorithm(Node initialNode) {
        int generations = 1000; // Số lượng thế hệ
        int generationCount = 0;

        while (generationCount < generations && initialNode.getH() > 0) {
            List<Node> candidates = initialNode.generateAllCandidates();
            Collections.sort(candidates, Comparator.comparingInt(Node::getH));

            if (candidates.get(0).getH() < initialNode.getH()) {
                initialNode = candidates.get(0);
            }

            generationCount++;
        }

        System.out.println("Final State after Genetic Algorithm:");
        initialNode.displayBoard();
        System.out.println("Final Heuristic: " + initialNode.getH());
    }
}
