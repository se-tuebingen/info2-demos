package graphs;

import java.util.LinkedList;

public class Vertex {
    final int id;
    final LinkedList<Vertex> neighbors = new LinkedList<>();

    boolean visited = false;
    int distance = -1;
    Vertex parent = null;

    public Vertex(int id) {
        this.id = id;
    }

    public void connectTo(Vertex destination) {
        if (!neighbors.contains(destination)) {
            neighbors.add(destination);
        }
    }

    public void disconnectFrom(Vertex destination) {
        neighbors.removeFirstOccurrence(destination);
    }

    public void resetSearchState() {
        visited = false;
        distance = -1;
        parent = null;
    }

    public String toString() {
        return Integer.toString(id);
    }
}