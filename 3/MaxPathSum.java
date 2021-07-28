class MaxPathSum {
	public static int[] getMaxPathSum(BinaryTree tree) {

		return new int[]{};
	}

	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();

		for(int i=1; i<=7; i++) {
			tree.insert(i);
		}

		getMaxPathSum(tree);
	}

}
