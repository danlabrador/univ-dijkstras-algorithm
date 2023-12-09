import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    try {
      //! Do not allow more than 20 vertices or more than 100 edges
      if (CS2135WeightedGraph.countComponents("graph.txt").get("vertexCount") > 20 &&
        CS2135WeightedGraph.countComponents("graph.txt").get("edgeCount") > 100 ){
        System.out.println("You have more than 20 vertices and more than 100 edges, which is not allowed.");
        return;
      } else if (CS2135WeightedGraph.countComponents("graph.txt").get("vertexCount") > 20){
        System.out.println("You have more than 20 vertices, which is not allowed.");
        return;
      }  else if (CS2135WeightedGraph.countComponents("graph.txt").get("edgeCount") > 100){
        System.out.println("You have more than 100 edges, which is not allowed.");
        return;
      }

      Scanner console = new Scanner(System.in);

      //! Generate the adjacency list
      Graph graph = CS2135WeightedGraph.createGraph("graph.txt", true); // Switch second argument to false for undirected graph
      graph.print(); System.out.println();

      //! Ask user to pick a starting vertex
      System.out.print("Above is the adjacency list.\nPick a starting vertex: ");
      String firstVertex = console.nextLine(); System.out.println();

      //! Find shortest path
      Hashtable<String, Integer>[] result = Dijkstra.dijkstra(graph, graph.getVertexByValue(firstVertex));
      Dijkstra.print(result, firstVertex);

      console.close();
    } catch (FileNotFoundException e){
      System.out.println("Please check file name.");
    }

  }
}
