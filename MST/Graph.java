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

    public int vertexExistsById(int id) {
        for (Vertex vertex : this.vertices) {
            if (vertex.getId() == id)
                return 1;
        }
        return 0;
    }

    public void print() {
        System.out.println(this.name + " : ");
        for (Vertex vertex : this.vertices) {
            String out = vertex.getId() + " : ";
            for (AdjNode adj : vertex.getAdjacentList()) {
                out = out + " ( " + adj.getId() + " , " + adj.getWeight() + " ) " + " , ";
            }
            System.out.println(out);
        }
    }
}
