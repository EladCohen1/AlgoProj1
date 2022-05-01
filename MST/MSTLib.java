package MST;

import java.util.PriorityQueue;

public class MSTLib {

    public static Graph MSTPrim(Graph graph) {
        PriorityQueue<Vertex> pQueue = new PriorityQueue<Vertex>();
        for (Vertex vertex : graph.getVertices()) {
            vertex.setKey(Double.POSITIVE_INFINITY);
            pQueue.add(vertex);
        }
        graph.getVertices()[0].setKey(0);
        graph.getVertices()[0].setPiId(-1);
        while (!pQueue.isEmpty()) {
            Vertex u = pQueue.remove();
            for (AdjNode node : u.getAdjacentList()) {
                // if V still in not done and w(u,v) < key[v]
                if (pQueue.contains(graph.getVertices()[node.getId()])
                        && node.getWeight() < graph.getVertices()[node.getId()].getKey()) {
                    graph.getVertices()[node.getId()].setPiId(u.getId());
                    graph.getVertices()[node.getId()].setKey(node.getWeight());
                }
            }
        }
        // initializing a new graph with the same amount of vertices as the original
        Vertex[] vertices = new Vertex[graph.getVertices().length];
        for (int i = 0; i < vertices.length; i++) {
            vertices[i].setId(i);
        }
        for (Vertex vertex : graph.getVertices()) {
            vertices[vertex.getPiId()].addAdjacentNode(new AdjNode(vertex.getId(), vertex.getKey()));
        }
        Graph MST = new Graph("MST", vertices);
        return MST;
    }

    // the new edge will be given as a type Vertex, that vertex will have the same
    // id as the first vertex connected, and the adjList will contain the added edge
    public static void MSTUpdate(Graph MST, Vertex newEdge) {
        // run BFS in MST from u to v, and look for the edge with the maximum weight. if
        // that edge has a larger weight than the new one. remove it and add the new one
    }
}
