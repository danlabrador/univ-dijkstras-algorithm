import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.PriorityQueue;

public class Dijkstra {
  public static Hashtable<String, Integer>[] dijkstra(Graph graph, Vertex firstVertex){
    Hashtable<String, Integer> currentDistances = new Hashtable<>();
    Hashtable<String, Vertex> predecessor = new Hashtable<>();
    PriorityQueue<QueueVertex> queue = new PriorityQueue<QueueVertex>();

    queue.add(new QueueVertex(firstVertex, 0));

    for (Vertex vertex: graph.vertices) {
      if (vertex != firstVertex) {
        currentDistances.put(vertex.data, Integer.MAX_VALUE);
      }
      predecessor.put(vertex.data, new Vertex("Null"));
    }

    currentDistances.put(firstVertex.data, 0);

    while (queue.size() != 0) {
      Vertex current = queue.poll().vertex;
      for (Edge e: current.edges) {
        Integer alternativeDistance = currentDistances.get(current.data) + e.weight;
        String adjacentData = e.end.data;
        if (alternativeDistance < currentDistances.get(adjacentData)) {
          currentDistances.put(adjacentData, alternativeDistance);
          predecessor.put(adjacentData, current);
          queue.add(new QueueVertex(e.end, currentDistances.get(adjacentData)));
        }
      }
    }
    
    return new Hashtable[]{currentDistances, predecessor};
  }

  public static void print(Hashtable<String, Integer>[] hashtable, String firstVertexData){
    String firstVertexString = "";
    ArrayList<String> destinations = new ArrayList<>();

    for (Enumeration<String> keys = hashtable[0].keys(); keys.hasMoreElements();){
      String nextKey = keys.nextElement();
      Integer distance = hashtable[0].get(nextKey);
      boolean infinity = false;

      if (distance == Integer.MAX_VALUE){
        infinity = true; 
      }

      if (!nextKey.equals(firstVertexData)){
        if (infinity){
          destinations.add(nextKey + " ∞");
        } else {
          destinations.add(nextKey + " " + distance);
        }
      } else {
        firstVertexString = "Starting Vertex: " + nextKey;
      }
    }

    System.out.println(firstVertexString);
    for (String nextVertexString: destinations){
      System.out.println(nextVertexString);
    }
  }

}
