import java.util.ArrayList;

public class Graph {
  public ArrayList<Vertex> vertices;
  public boolean isWeighted;
  public boolean isDirected;

  public Graph(boolean isWeighted, boolean isDirected){
    this.vertices = new ArrayList<Vertex>();
    this.isWeighted = isWeighted;
    this.isDirected = isDirected;
  }

  public Vertex addVertex(String data){
    Vertex newVertex = new Vertex(data);
    this.vertices.add(newVertex);
    return newVertex;
  }

  public void addEdge(Vertex vertex1, Vertex vertex2, Integer weight){
    if (!this.isWeighted) weight = null;

    // Add the edge
    vertex1.addEdge(vertex2, weight);
    if (!this.isDirected) vertex2.addEdge(vertex1, weight);
  }

  public void removeEdge(Vertex vertex1, Vertex vertex2){
    vertex1.removeEdge(vertex2);
    if(!this.isDirected) vertex2.removeEdge(vertex1);
  }

  public void removeVertex(Vertex vertex){
    this.vertices.remove(vertex);
  }

  public Vertex getVertexByValue(String value) {
		for(Vertex vertex: this.vertices) { 
			if (vertex.data.equals(value)) {
				return vertex;
			}
		}

		return null;
	}
	
	public void print() {
		for(Vertex v: this.vertices) {
			v.print(isWeighted);
		}
	}
}
