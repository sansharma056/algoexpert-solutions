import java.util.LinkedList;
import java.util.Queue;

public class Tree {
	private Node root = null;	

	public class Node {
		public int value;
		public Node left = null;
		public Node right = null;

		Node(int value) {
			this.value = value;
		}
	}

	public Node getRoot() {
		return root;
	}

	public void insert(int value) {
		
		if(root == null) {
			root = new Node(value);
			return;
		} 
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		
		while(!q.isEmpty()) {
			Node temp = q.remove();

			if(temp.left == null) {
				temp.left = new Node(value);
				break;
			} else {
					q.add(temp.left);
			}

			if(temp.right == null) {
				temp.right = new Node(value);
				break;
			} else {
					q.add(temp.right);
			}
		}

	}
	
	public void insert(int values[]) {
		for(int value : values) {
			this.insert(value);
		}
	}

}
