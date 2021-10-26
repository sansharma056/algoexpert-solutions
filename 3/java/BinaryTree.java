import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	public Node root = null;	

	public static class Node {
		public int data;
		public Node left;
		public Node right;

		Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}
	
	public void insert(int data) {
		if(root == null) {
			root = new Node(data);
			return;
		}

		Queue<Node> q = new LinkedList<>();
		q.add(root);

		while(!q.isEmpty()) {
			Node cur = q.remove();

			if(cur.left == null) {
				cur.left = new Node(data);
				return;
			} else {
					q.add(cur.left);
			}
		
			if(cur.right == null) {
				cur.right = new Node(data);
				return;
			} else {
					q.add(cur.right);
			}
		}
	}
		
	public void print() {
		this.print(root);
	}

	void print(Node root) {
		if(root == null) {
			return;
		}
		
		System.out.print(root.data + " ");
		print(root.left);
		print(root.right);
	}

	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		int arr[] = {1,2,3,5,6,7};

		for(int data : arr) {
			tree.insert(data);
		}

		tree.print();
	}
}
