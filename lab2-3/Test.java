package bt2;

public class Test {
    public static void main(String[] args) {
        Node nodeS = new Node("S");
        Node nodeA = new Node("A");
        Node nodeC = new Node("C");
        Node nodeE = new Node("E");
        Node nodeG = new Node("G");
        nodeS.addEdge(nodeA, 1);
        nodeS.addEdge(nodeC, 41);
        nodeA.addEdge(nodeE, 4);
        Node nodeB = new    Node("B");
        Node nodeD = new   Node("D");
        Node nodeF = new  Node("F");
        Node nodeH = new  Node("H");
        nodeS.addEdge(nodeB, 2);
        nodeA.addEdge(nodeD, 9);
        nodeB.addEdge(nodeG, 6);
        nodeC.addEdge(nodeF, 2);
        nodeD.addEdge(nodeH, 7);
        nodeE.addEdge(nodeG, 1);
        nodeF.addEdge(nodeG, 1);
        ISearchAlgo algo1 = new BreadthFirstSearchAlgo();
      ISearchAlgo algo2 = new UniformCostSearchAlgo();
        Node result = algo2.execute(nodeS, "G");
        System.out.println(NodeUtils.printPath(result));

    }
}
