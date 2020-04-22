package Graphs.Undirected;

public interface IGraph<T> {
  void addVertex(T vertex);

  void addEdge(T fromVert, T toVert);

  Iterable<T> getPath(T from, T to);

}
