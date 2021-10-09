import java.util.ArrayList; 
import java.util.Queue;
import java.util.LinkedList;

class Graph <E> {
	ArrayList<Node> nodes = new ArrayList<Node>();	

	class Node <E> {
		E data;	
		ArrayList<Node> children = new ArrayList<Node>();

		Node(E data) {
			this.data = data;
		}
	}
	
	public Node getNode(E data) {
		for(Node node : this.nodes) {
			if(node.data == data) {
				return node;
			}
		}

		return null;
	}

	public void addEdge(E fromData, E toData) {
		Node from = null;
		Node to = null;
		
		for(Node node : this.nodes) {
			if(fromData == node.data) {
				from = node;
			}

			if(toData == node.data) {
				to = node;
			}
		}	

		if(from == null) {
			from = new Node(fromData);
			this.nodes.add(from);
		}

		if(to == null) {
			to = new Node(toData);
			this.nodes.add(to);
		}
		
		from.children.add(to);
	}
	
	public void bfs(Node startNode) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(startNode);

		while(!q.isEmpty()) {
			Node cur = q.remove();
		

			for(Object node : cur.children) {
				q.add((Node)node);
			}

			System.out.print(cur.data + " ");
		}

		System.out.println();
	}
	public static void main(String args[]) {
		Graph<String> g = new Graph<String>();

		g.addEdge("A", "B");
		g.addEdge("A", "C");
		g.addEdge("A", "D");

		g.addEdge("B", "E");
		g.addEdge("B", "F");

		g.addEdge("D", "G");
		g.addEdge("D", "H");

		g.addEdge("F", "I");
		g.addEdge("F", "J");

		g.addEdge("G", "K");
		
		g.bfs(g.getNode("A"));
	}
}
