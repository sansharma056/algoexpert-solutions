class MaxPathSum {
	public static int[] getMaxPathSumHelper(BinaryTree.Node root) {
		if(root == null) {
			return new int[]{0, 0};
		}
		
		int leftMax[] = getMaxPathSumHelper(root.left);
		int rightMax[] = getMaxPathSumHelper(root.right);
		int childBranchMax = Math.max(leftMax[1], rightMax[1]);
			
		int rootVal = root.data;

		int maxBranch = Math.max(childBranchMax + rootVal, rootVal);
		int maxSum = Math.max(leftMax[1] + rightMax[1] + rootVal, maxBranch);
		int maxPath = Math.max(Math.max(leftMax[0], rightMax[0]), maxSum);	

		return new int[]{maxPath, maxBranch};
	}
	
	public static int getMaxPathSum(BinaryTree.Node root) {
		int[] max = getMaxPathSumHelper(root); 
		return max[0];
	}

	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();

		for(int i=1; i<=7; i++) {
			tree.insert(i);
		}

		System.out.println(getMaxPathSum(tree.root));
	}
}
