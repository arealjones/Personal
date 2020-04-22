package Graphs.Undirected;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

public class UndirectedGraph<T> implements IGraph<T> {

  Map<T, Set<T>> vertices;

  public UndirectedGraph() {
    this.vertices = new HashMap<>();
  }

  private boolean containsVertex(T vertex) {
    return this.vertices.containsKey(vertex);
  }

  @Override
  public void addVertex(T vertex) {
    if (!this.containsVertex(vertex)) {
      this.vertices.put(vertex, new HashSet<>());
    }
  }

  @Override
  public void addEdge(T fromVert, T toVert) {
    if (!this.containsVertex(fromVert) || !this.containsVertex(toVert)) {
      throw new NoSuchElementException();
    }
    this.vertices.get(fromVert).add(toVert);
    this.vertices.get(toVert).add(fromVert);
  }

  private void processNeighbors(T current, LinkedList<T> toVisit, Map<T, T> prev) {
    for (T vertex: this.vertices.get(current)) {
      if (!prev.containsKey(vertex)) {
        toVisit.add(vertex);
        prev.put(vertex, current);
      }
    }
  }

  private T createQueue(T current, T to, LinkedList<T> toVisit, Map<T, T> prev) {
    while (!toVisit.isEmpty()) {
      current = toVisit.remove();
      if (current.equals(to)) {
        return current;
      } else {
        this.processNeighbors(current, toVisit, prev);
      }
    }

    return current;
  }

  private List<T> createPath(T current, T to, Map<T, T> visited) {
    List<T> directions = new LinkedList<>();
    if (!current.equals(to)){
      return directions;
    }

    T node = to;
    while (node != null) {
      directions.add(0, node);
      node = visited.get(node);
    }
    return directions;
  }

  @Override
  public List<T> getPath(T from, T to) {
    Map<T, T> visited = new HashMap<>();
    LinkedList<T> toVisit = new LinkedList<>();
    toVisit.add(from);
    visited.put(from, null);

    T current = this.createQueue(from, to, toVisit, visited);

    return this.createPath(current, to, visited);
  }

  @Override
  public String toString() {
    String msg = "";
    for (T vertex: vertices.keySet()) {
      msg += vertex.toString() + " | ";
      for (T conn: vertices.get(vertex)) {
        msg += conn.toString() + " ";
      }
      msg += System.lineSeparator();
    }
    return msg;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UndirectedGraph<?> that = (UndirectedGraph<?>) o;
    return Objects.equals(vertices, that.vertices);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vertices);
  }
}
