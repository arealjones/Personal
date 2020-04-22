package Graphs.Undirected;

public class Main {
  public static void main(String[] args) {
    UndirectedGraph<String> strGraph = new UndirectedGraph<>();
    strGraph.addVertex("A");
    strGraph.addVertex("B");
    strGraph.addVertex("C");
    strGraph.addVertex("D");
    strGraph.addVertex("E");
    strGraph.addVertex("F");

    strGraph.addEdge("A", "B");
    strGraph.addEdge("B", "C");
    strGraph.addEdge("B", "D");
    strGraph.addEdge("C", "D");
    strGraph.addEdge("D", "E");
    System.out.println(strGraph.toString());



    System.out.println(strGraph.getPath("C", "E"));

  }


}
