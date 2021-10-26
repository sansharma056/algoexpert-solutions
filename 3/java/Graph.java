import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Graph {
	List<Node> vertices = new ArrayList<>();

	public static class Node {
		public int data;
		public boolean visited = false;
		public boolean visiting = false;
		public List<Node> dependencies = new ArrayList<>();

		Node(int data) {
			this.data = data;
		}
		
		@Override
		public String toString() {
			return String.valueOf(this.data);
		}

		@Override
		public int hashCode() {
			return Objects.hashCode(data);
		}

		@Override
		public boolean equals(Object o) {
			if(o == this) {
				return true;
			}	

			if(!(o instanceof Node)) {
				return false;
			}
			
			Node n = (Node)o;
			if(n.data != this.data) {
				return false;
			}

			return true;
		}
	}
	
	public Node search(int data) {
		for(Node node : vertices) {
			if(node.equals(new Node(data))) {
				return node;
			}
		}
		return null;
	}	
	

	public Node insertVertex(int data) {
		Node vertex = search(data);

		if(vertex != null) {
			return vertex;
		}
		
		vertex = new Node(data);
		this.vertices.add(vertex);

		return vertex;
	}

	public void insertEdge(int fromData, int toData) {
		Node from = search(fromData);	
		Node to = search(toData);
			
		if(from == null) {
			from = insertVertex(fromData);
		}

		if(to == null) {
			to = insertVertex(toData);
		}
		
		to.dependencies.add(from);
	}
	
	public List<Node> getVertices() {
		return this.vertices;
	}

	@Override
	public String toString() {
		return this.vertices.toString();
	}
}
