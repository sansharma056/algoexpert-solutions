import java.util.ArrayList;

class DFS {
	
	public static void getVerticesDFS(Graph.Vertex vertex, ArrayList<String> vertices) {
		
		String nodeName = (String)vertex.getData();
		vertices.add((String)vertex.getData());
		//vertices.add(nodeName);
	
		ArrayList<Graph.Vertex> adjacentVertices = vertex.getAdjacentVertices();
		for(Graph.Vertex adjacentVertex : adjacentVertices) {
			getVerticesDFS(adjacentVertex, vertices);
		}		
	}

	public static void main(String args[]) {
		
		Graph<String> graph = new Graph<String>();
		
		graph.addEdge("A", "B");
		graph.addEdge("A", "C");
		graph.addEdge("A", "D");

		graph.addEdge("B", "E");
		graph.addEdge("B", "F");
		
		graph.addEdge("D", "G");
		graph.addEdge("D", "H");


		graph.addEdge("F", "I");
		graph.addEdge("F", "J");

		graph.addEdge("G", "K");

		ArrayList<String> vertices = new ArrayList<String>();
		
		getVerticesDFS(graph.getVertex("A"), vertices);
		
		for(String vertex : vertices) {
			System.out.print(vertex);
		}

		System.out.println();
	}
}
