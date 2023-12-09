public class QueueVertex implements Comparable<QueueVertex> {
  public Vertex vertex;
  public int priority;

  public QueueVertex(Vertex vertex, int priority){
      this.vertex = vertex;
      this.priority = priority;
  }

  @Override
  public int compareTo(QueueVertex o) {
      if (this.priority == o.priority){
          return 0;
      }
      else if (this.priority > o.priority){
          return 1;
      }
      else {
          return -1;
      }
  }
}
