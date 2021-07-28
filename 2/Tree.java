import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Tree {
	Node root = null;	
	
	public Node getRoot() {
		return this.root;
	}

	class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}

		public int getData() {
			return this.data;
		}
	}

	public void insert(int data) {
		if(this.root == null) {
			this.root = new Node(data);
			return;
		}

		Queue<Node> q = new LinkedList<Node>();
		q.add(this.root);


		while(!q.isEmpty()) {
			Node node = q.remove();
			
			if(node.left == null) {
				node.left = new Node(data);
				break;
			} else {
					q.add(node.left);
			}

			if(node.right == null) {
				node.right = new Node(data);
				break;
			} else {
					q.add(node.right);
			}
		}
	}

	public boolean isBST(Node node, int min, int max) {
		if(node == null) {
			return true;
		}
	
		if(node.data < min || node.data > max) {
			return false;
		}

		boolean isLeftBST = this.isBST(node.left, min, node.data);
		boolean isRightBST = this.isBST(node.right, node.data, max);

		return isLeftBST && isRightBST;
	}
	
	public void invertTree() {
		this.root = invertTree(this.root);
	}
	
	public static Node invertTree(Node root) {
		if(root == null) {
			return null;
		}
		
		Node temp = root.left;

		root.left = invertTree(root.right);
		root.right = invertTree(temp);

		return root;
	}
	/*
	Node invertTree(Node node) {
		Stack<Node> stack = new Stack<Node>();
		if(node.left != null) {
			stack.push(node.left);
		}

		if(node.right != null) {
			stack.push(node.right);
		}
		
		if(stack.empty()) {
			node.left = null;
			node.right = null;
		} else {
				node.left = invertTree(stack.pop());
				
				if(stack.empty()) {
					node.right = null;
				} else {
						node.right = invertTree(stack.pop());
				}
		}
		return node;
	}
	*/	

	public void printPreorder() {
		printPreorder(this.root);
		System.out.println();
	}

	void printPreorder(Node node) {
		if(node == null) {
			return;
		}

		System.out.print(node.data + " ");
		printPreorder(node.left);
		printPreorder(node.right);
	}

	public static void main(String args[]) {
		Tree tree = new Tree();
		int arr[] = {1,2,3,4,5,6,7,8,9};

		for(int i : arr) {
			tree.insert(i);	
		}
		tree.printPreorder();
		tree.invertTree();
		tree.printPreorder();
	}
}
