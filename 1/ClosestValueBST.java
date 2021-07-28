class ClosestValueBST {
	public static int closestVal(BST bst, int value) {
		BST.Node root = bst.getRoot();		
		int closest = root.value;

		while(root!= null) {
			if( Math.abs(closest-value) > Math.abs(root.value-value) ) {
						closest = root.value;
			}

			if(value < root.value) {
					root = root.left;
			} else if(value > root.value) {		
					root = root.right;
			} else {
					return value;
			}
		}

		return closest;
	}

	public static void main(String args[]) {
		BST bst = new BST();
		int value = 12;

		bst.insert(new int[]{10, 5, 15, 2, 6, 13, 22, 14});


		System.out.println( closestVal(bst, value) ); 
	}
	
}
