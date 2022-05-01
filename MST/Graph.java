package MST;

public class Graph {
    // a graph has an array of Vertices, which are ordered by id, each vertex's id
    // will correspond to its position in the array
    // for example Vertex id 1 will be at vertices[1]

    private Vertex[] vertices;
    private String name;

    public Graph(String name, Vertex[] vertices) {
        this.vertices = vertices;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Vertex[] getVertices() {
        return this.vertices;
    }
}
