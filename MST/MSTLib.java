// אלעד כהן - 318918968
// עמית קפלן - 209049972

package MST;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MSTLib {

    public static Graph MSTPrim(Graph graph) {
        PriorityQueue<Vertex> pQueue = new PriorityQueue<Vertex>();
        for (Vertex vertex : graph.getVertices()) {
            vertex.setKey(Double.POSITIVE_INFINITY);
            vertex.setPiId(-1);
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
                    pQueue.remove(graph.getVertices()[node.getId()]);
                    pQueue.add(graph.getVertices()[node.getId()]);
                }
            }
        }
        // initializing a new graph with the same amount of vertices as the original
        Vertex[] vertices = new Vertex[graph.getVertices().length];
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = new Vertex(i);
        }
        for (Vertex vertex : graph.getVertices()) {
            if (vertex.getPiId() != -1) {
                vertices[vertex.getPiId()].addAdjacentNode(new AdjNode(vertex.getId(), vertex.getKey()));
                vertices[vertex.getId()].addAdjacentNode(new AdjNode(vertex.getPiId(), vertex.getKey()));
            }
        }
        Graph MST = new Graph("MST", vertices);
        return MST;
    }

    // the new edge will be given as a type Vertex, that vertex will have the same
    // id as the first vertex connected, and the adjList will contain the added edge
    public static void MSTUpdate(Graph MST, Vertex newEdge) {
        // run BFS in MST from u to v, and look for the edge with the maximum weight. if
        // that edge has a larger weight than the new one. remove it and add the new one

        // checking that both vertices of the new edge exist in the given tree
        if (MST.vertexExistsById(newEdge.getId()) == 0
                || MST.vertexExistsById(newEdge.getAdjacentList().getFirst().getId()) == 0) {
            System.out.println("the vertex given does not exist in the given tree");
            return;
        }

        // initialize vertex color and pi
        // we dont need to save distance because we dont care about the distance, we're
        // just looking for the largest edge on the way from u to v
        for (Vertex vertex : MST.getVertices()) {
            vertex.setBFSColor("white");
            vertex.setBFSPiId(-1);
        }
        // initializing u (the vertex we run the BFS from)
        MST.getVertices()[newEdge.getId()].setBFSColor("gray");
        MST.getVertices()[newEdge.getId()].setBFSPiId(-1);

        Queue<Vertex> queue = new LinkedList<Vertex>();
        queue.add(MST.getVertices()[newEdge.getId()]);

        // BFS
        while (!queue.isEmpty()) {
            Vertex u = queue.remove();
            for (AdjNode adj : u.getAdjacentList()) {
                if (MST.getVertices()[adj.getId()].getBFSColor() == "white") {
                    MST.getVertices()[adj.getId()].setBFSColor("gray");
                    MST.getVertices()[adj.getId()].setBFSPiId(u.getId());
                    MST.getVertices()[adj.getId()].setBFSPiEdgeWeight(adj.getWeight());
                    queue.add(MST.getVertices()[adj.getId()]);
                }
            }
            u.setBFSColor("black");
        }

        // now we run through the way from v back to u and looking for the largest edge
        Vertex largestEdge = new Vertex();
        // starting from v
        Vertex currVertex = MST.getVertices()[newEdge.getAdjacentList().getFirst().getId()];
        largestEdge.setId(currVertex.getId());
        largestEdge.addAdjacentNode(new AdjNode(currVertex.getBFSPiId(), currVertex.getBFSPiEdgeWeight()));
        currVertex = MST.getVertices()[currVertex.getBFSPiId()];
        while (currVertex.getId() != newEdge.getId()) {
            if (currVertex.getBFSPiEdgeWeight() > largestEdge.getAdjacentList().getFirst().getWeight()) {
                largestEdge = new Vertex();
                largestEdge.setId(currVertex.getId());
                largestEdge.addAdjacentNode(new AdjNode(currVertex.getBFSPiId(), currVertex.getBFSPiEdgeWeight()));
            }
            currVertex = MST.getVertices()[currVertex.getBFSPiId()];
        }
        if (largestEdge.getAdjacentList().getFirst().getWeight() > newEdge.getAdjacentList().getFirst().getWeight()) {
            // removing old edge
            MST.getVertices()[largestEdge.getId()].removeAdjacentNode(largestEdge.getAdjacentList().getFirst().getId());
            MST.getVertices()[largestEdge.getAdjacentList().getFirst().getId()].removeAdjacentNode(largestEdge.getId());
            // adding new edge
            MST.getVertices()[newEdge.getId()].addAdjacentNode(newEdge.getAdjacentList().getFirst());
            MST.getVertices()[newEdge.getAdjacentList().getFirst().getId()]
                    .addAdjacentNode(new AdjNode(newEdge.getId(), newEdge.getAdjacentList().getFirst().getWeight()));
        }
        ;
    }
}
