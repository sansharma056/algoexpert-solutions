public class BST {
	private Node root = null;	

	public class Node {
		public int value;
		public Node left = null;
		public Node right = null;

		Node(int value) {
			this.value = value;
		}
	}

	public void insert(int value) {
	
		Node prev = null;
		Node temp = root;

		while(temp != null) {
			prev = temp;

			if(value < temp.value) {
				temp = temp.left;
			} else {
				temp = temp.right;
			}
		}

		if (prev == null) {
			root = new Node(value);
		} else if(value < prev.value) {
			prev.left = new Node(value);
		} else {
			prev.right = new Node(value);
		}
	}
	
	public void insert(int arr[]) {
		for(int i: arr) {
			this.insert(i);
		}
	}

	public Node getRoot() {
		return root;
	}
	
}
