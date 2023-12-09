import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class CS2135WeightedGraph {
  public static Graph createGraph(String fileName, boolean isDirected) throws FileNotFoundException{
    Scanner reader = new Scanner(new FileReader(fileName));
    Graph graph = new Graph(true, isDirected);

    while(reader.hasNextLine()){
      String line = reader.nextLine();
      line = line.strip();

      // Add vertices
      if (line.length() == 1) graph.addVertex(line);
      
      // Add edges
      if (line.length() - line.replace(" ", "").length() == 2){
        String[] components = line.split("\\s+");

        graph.addEdge(graph.getVertexByValue(components[0]), graph.getVertexByValue(components[1]), Integer.parseInt(components[2]));
      }
    }

    return graph;
  }

  public static HashMap<String,Integer> countComponents(String fileName) throws FileNotFoundException {
    Scanner reader = new Scanner(new FileReader(fileName));
    HashMap<String,Integer> componentCount = new HashMap<>();
    int vertices = 0, edges = 0;

    while(reader.hasNextLine()){
      String line = reader.nextLine();
      line = line.strip();

      // Count components
      if (line.length() == 1) vertices++;
      if (line.length() - line.replace(" ", "").length() == 2) edges++;
    }

    componentCount.put("vertexCount", vertices);
    componentCount.put("edgeCount", edges);

    return componentCount;
  }
}
