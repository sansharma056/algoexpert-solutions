import java.util.ArrayList;

class BST {
	Node root = null;	
	
	BST(int data) {
		this.root = new Node(data);
	}

	class Node {
		public int data;	
		public Node left;
		public Node right;
		
		int getData() {
			return data;
		}

		Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}

	public Node getRoot() {
		return this.root;
	}
	
	public void insert(int data) {

		Node currentNode = root;
		Node parent = currentNode;
		boolean isLeft = true;	

		while(currentNode != null) {
			parent = currentNode;
			
			if(data < currentNode.data) {
				currentNode = currentNode.left;
				isLeft = true;
			} else if(data > currentNode.data) {
					currentNode = currentNode.right;	
					isLeft = false;
			}
		}
	
		Node newNode = new Node(data);
		if(parent == null) {
			this.root = newNode;
		} else if(isLeft) {
				parent.left = newNode;
		} else if(!isLeft) {
				parent.right = newNode;
		}
	}
	
	public Node search(int data) {
		Node currentNode = root;
		while(true) {
			if(currentNode == null) {
				return null;
			}

			if(currentNode.data == data) {
				return currentNode; 
			} else if(currentNode.data > data) {
					currentNode = currentNode.left;
			} else {
					currentNode = currentNode.right;
			}
		}
	}
	
	public void delete(int data) {
		Node currentNode = this.root;
		Node parent = currentNode;
		boolean isLeft = true;

		while(currentNode != null) {
			if(data == currentNode.data) {
				break;
			} else if(data < currentNode.data) {
					isLeft = true;
					parent = currentNode;
					currentNode = currentNode.left;
			} else if(data > currentNode.data) {
					isLeft = false;
					parent = currentNode;
					currentNode = parent.right;
			}
		}
		
		if(currentNode == null) {
			return;
		} 

		if(currentNode.left == null && currentNode.right == null) {
			if(currentNode.data == this.root.data) {
				this.root = null;
				return;
			}

			if(isLeft) {
				parent.left = null;
			} else {
					parent.right = null;
			}
		} else if(currentNode.left == null) {
				if(isLeft) {
					parent.left = currentNode.right;
				} else {
						parent.right = currentNode.right;
				}
		} else if(currentNode.right == null) {
				if(isLeft) {
					parent.left = currentNode.left;
				} else {
						parent.right = currentNode.left;
				}
		} else {
				Node parent2 = currentNode.right;
				Node currentNode2 = currentNode.right.left;
				
				if(currentNode2 == null) {
					currentNode.data = parent2.data; 
					currentNode.right = null;
					return;
				}

				while(currentNode2.left != null) {
					parent = currentNode2;
					currentNode2 = currentNode2.left;
				}

				currentNode.data = currentNode2.data;
				parent2.left = currentNode2.right;
		}
	}
	
	public static void printInorder(Node root, ArrayList<Integer> arr) {
		if(root == null) {
			return;
		}
		
		printInorder(root.left,arr);
		arr.add(root.data);
		printInorder(root.right,arr);
	}
	
	public static void printPreorder(Node root, ArrayList<Integer> arr) {
		if(root == null) {
			return;
		}

		arr.add(root.data);
		printPreorder(root.left,arr);
		printPreorder(root.right,arr);
	}
	
	public static void  printPostorder(Node root, ArrayList<Integer> arr) {
		if(root == null) {
			return;
		}

		printPostorder(root.left,arr);
		printPostorder(root.right,arr);
		arr.add(root.data);
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
	
	//Time Complexity : O(nlogn) Space Complexity : O(n)
	/*
	public void createBalancedBST(int arr[], int start, int end) {
		if(start <= end) {
			int mid = (start+end)/2;

			this.insert(arr[mid]);
			createBalancedBST(arr, start, mid-1);
			createBalancedBST(arr, mid+1, end);
		}
	}
	*/

	public static Node createBalancedBST(int arr[], int start, int end) {
		if(start <= end) {
			int mid = (start + end)/2;

			BST bst = new BST(arr[mid]);
			bst.getRoot().left = createBalancedBST(arr, start, mid-1);	
			bst.getRoot().right = createBalancedBST(arr, mid+1, end);

			return bst.getRoot();
		} else {
				return null;
		}
	}

	public static void main(String args[]) {
		int arr[]	= {1,2,5,7,10,13,14,15,22};
		
		Node root = createBalancedBST(arr, 0, arr.length-1);
		ArrayList<Integer> order = new ArrayList<Integer>();
		printPostorder(root, order);

		for(Integer i : order) {
			System.out.print(i + " ");
		}
		
		System.out.println();
	}
}
