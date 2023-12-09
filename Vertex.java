import java.util.ArrayList;

public class Vertex {
  public String data;
  public ArrayList<Edge> edges;

  public Vertex(String inputData){
    this.data = inputData;
    this.edges = new ArrayList<Edge>();
  }

  public void addEdge(Vertex endVertex, Integer weight){
    this.edges.add(new Edge(this, endVertex, weight));
  }

  public void removeEdge(Vertex endVertex){
    this.edges.removeIf(edge -> edge.end.equals(endVertex));
  }

  public void print(boolean showWeight) {
		String message = "";
		
		if (this.edges.size() == 0) {
			System.out.println(this.data + " -->");
			return;
		}
		
		for(int i = 0; i < this.edges.size(); i++) {
			if (i == 0) {
				message += this.edges.get(i).start.data + " -->  ";
			}

			message += this.edges.get(i).end.data;

			if (showWeight) {
				message += "(" + this.edges.get(i).weight + ")";
			}

			if (i != this.edges.size() - 1) {
				message += ", ";
			}
		}
		System.out.println(message);
	}

}
