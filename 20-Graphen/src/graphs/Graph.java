package graphs;

import java.util.*;

public class Graph {
    private final LinkedList<Vertex> vertices = new LinkedList<>();
    private int nextVertexID = 0;

    public Graph(int vertexCount) {
        for (int i = 0; i < vertexCount; i++) {
            addVertex();
        }
    }

    public int addVertex() {
        Vertex v = new Vertex(nextVertexID++);
        vertices.add(v);
        return v.id;
    }

    public void connect(int i, int j) {
        getVertex(i).connectTo(getVertex(j));
    }

    public void connectBidirectional(int i, int j) {
        Vertex v_i = getVertex(i);
        Vertex v_j = getVertex(j);
        v_i.connectTo(v_j);
        v_j.connectTo(v_i);
    }

    public void connectAll() {
        for (Vertex v1 : vertices) {
            for (Vertex v2 : vertices) {
                if (v1 != v2) {
                    v1.connectTo(v2);
                }
            }
        }
    }

    public void deleteVertex(int id) {
        Iterator<Vertex> iterator = vertices.iterator();
        while (iterator.hasNext()) {
            Vertex vertex = iterator.next();
            if (vertex.id == id) {
                iterator.remove();
                for (Vertex otherVertex : vertices) {
                    otherVertex.disconnectFrom(vertex);
                }
                return;
            }
        }
    }

    public Vertex getVertex(int id) {
        for (Vertex v : vertices) {
            if (v.id == id) {
                return v;
            }
        }
        return null;
    }

    public Iterable<Vertex> getVertices() {
        return vertices;
    }

    public int getVertexCount() {
        return vertices.size();
    }

    private void resetSearchState() {
        for (Vertex v : vertices) {
            v.resetSearchState();
        }
    }

    public void depthFirstSearchRecursive(int rootId) {
        resetSearchState();
        Vertex rootVertex = getVertex(rootId);
        rootVertex.distance = 0;
        depthFirstSearchRecursive(rootVertex);
    }

    private void depthFirstSearchRecursive(Vertex start) {
        start.visited = true;
        System.out.print(start.id + " ");

        for (Vertex dest : start.neighbors) {
            if (!dest.visited) {
                dest.parent = start;
                dest.distance = start.distance + 1;
                depthFirstSearchRecursive(dest);
            }
        }
    }

    public void depthFirstSearchIterative(int rootId) {
        resetSearchState();
        Vertex rootVertex = getVertex(rootId);
        rootVertex.distance = 0;

        Deque<Vertex> stack = new LinkedList<>();
        stack.addFirst(rootVertex);

        while (!stack.isEmpty()) {
            Vertex v = stack.removeFirst();
            if (v.visited) {
                continue;
            }
            v.visited = true;
            System.out.print(v.id + " ");

            for (Vertex dest : v.neighbors) {  // use v.neighbors.reversed() for same order as recursive DFS
                if (!dest.visited) {
                    dest.parent = v;
                    dest.distance = v.distance + 1;

                    stack.addFirst(dest);
                }
            }
        }
    }

    public void breadthFirstSearch(int rootId) {
        resetSearchState();
        Vertex rootVertex = getVertex(rootId);
        rootVertex.distance = 0;
        rootVertex.visited = true;

        Queue<Vertex> queue = new LinkedList<>();
        queue.add(rootVertex);

        while (!queue.isEmpty()) {
            Vertex v = queue.remove();
            for (Vertex dest : v.neighbors) {
                if (!dest.visited) {
                    dest.visited = true;
                    System.out.print(dest.id + " ");

                    dest.parent = v;
                    dest.distance = v.distance + 1;

                    queue.add(dest);
                }
            }
        }
    }

    public void print() {
        System.out.println("--------------------");
        System.out.println("Graph with " + getVertexCount() + " vertices:");
        System.out.print(" Vertex ID: ");
        for (Vertex v : vertices) {
            System.out.print("     " + v);
        }
        System.out.println();
        System.out.print("  Distance: ");
        for (Vertex v : vertices) {
            System.out.printf(" %5d", v.distance);
        }
        System.out.println();
        System.out.print("   Visited: ");
        for (Vertex v : vertices) {
            System.out.printf(" %5s", v.visited);
        }
        System.out.println();
        System.out.print("    Parent: ");
        for (Vertex v : vertices) {
            if (v.parent == null) {
                System.out.printf(" %5s", "--");
            } else {
                System.out.printf(" %5d", v.parent.id);
            }
        }
        System.out.println("\n");
        System.out.println("Adjacency List:");

        for (Vertex v : vertices) {
            System.out.print(v.id + ": ");
            for (Vertex dest : v.neighbors) {
                System.out.print(dest.id + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }

    public void visualize(String title) {
        GraphVisualizer.visualizeGraph(this, title);
    }

    public static void main(String[] args) {
        Graph g = new Graph(8);
        g.connectBidirectional(0, 5);
        g.connectBidirectional(0, 2);
        g.connectBidirectional(0, 1);
        g.connect(0, 6);
        g.connect(2, 1);
        g.connectBidirectional(6, 4);
        g.connectBidirectional(4, 5);
        g.connectBidirectional(5, 3);
        g.connectBidirectional(3, 4);
        g.print();
        g.visualize("Initial");

        System.out.println("Recursive DFS from vertex 0:");
        g.depthFirstSearchRecursive(0);
        System.out.println();
        g.print();
        g.visualize("Recursive DFS");

        System.out.println("Iterative DFS from vertex 0:");
        g.depthFirstSearchIterative(0);
        System.out.println();
        g.print();
        g.visualize("Iterative DFS");

        System.out.println("BFS from vertex 0:");
        g.breadthFirstSearch(0);
        System.out.println();
        g.print();
        g.visualize("BFS");

        System.out.println("Removing vertex 4:");
        g.resetSearchState();
        g.deleteVertex(4);
        g.print();
        g.visualize("After removing vertex 4");
    }
}
