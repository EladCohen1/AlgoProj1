package MST;

public class MainTrain {

	public static void main(String[] args) {
		System.out.println("running");
		// initializing vertices array
		Vertex[] vertices = new Vertex[20];
		for (int i = 0; i < vertices.length; i++) {
			vertices[i] = new Vertex(i);
			if (i > 0) {
				Double weight = Math.floor(Math.random() * 20 + 1);
				vertices[i].addAdjacentNode(new AdjNode(i - 1, weight));
				vertices[i - 1].addAdjacentNode(new AdjNode(i, weight));
			}
		}
		for (int i = 2; i < vertices.length; i++) {
			if (i > 0) {
				Double weight = Math.floor(Math.random() * 20 + 1);
				vertices[0].addAdjacentNode(new AdjNode(i - 1, weight));
				vertices[i - 1].addAdjacentNode(new AdjNode(0, weight));
			}
		}

		for (int i = 10; i < vertices.length; i++) {
			if (i > 0) {
				Double weight = Math.floor(Math.random() * 20 + 1);
				vertices[5].addAdjacentNode(new AdjNode(i - 1, weight));
				vertices[i - 1].addAdjacentNode(new AdjNode(5, weight));
			}
		}

		for (int i = 10; i < vertices.length; i++) {
			if (i > 0) {
				Double weight = Math.floor(Math.random() * 20 + 1);
				vertices[8].addAdjacentNode(new AdjNode(i - 1, weight));
				vertices[i - 1].addAdjacentNode(new AdjNode(5, weight));
			}
		}

		Graph graph = new Graph("myGraph", vertices);
		graph.print();
		Graph MST = MSTLib.MSTPrim(graph);
		MST.print();

		Vertex newEdge = new Vertex(0);
		newEdge.addAdjacentNode(new AdjNode(3, 30));
		System.out.println("added an edge from node 0 to node 3 with a weight of 30");
		MSTLib.MSTUpdate(MST, newEdge);
		MST.print();

		Vertex newEdgeChange = new Vertex(0);
		newEdgeChange.addAdjacentNode(new AdjNode(3, 1));
		System.out.println("added an edge from node 0 to node 3 with a weight of 1");
		MSTLib.MSTUpdate(MST, newEdgeChange);
		MST.print();

		System.out.println("done!");
	}

}
