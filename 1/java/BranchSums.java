import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class BranchSums {

	public static ArrayList<Integer> getBranchSums(Tree tree) {
		ArrayList<Integer> branchSums = new ArrayList<Integer>();
		Queue<Tree.Node> q = new LinkedList<Tree.Node>();		
	
		q.add(tree.getRoot());
		
		int sum = 0;

		while(!q.isEmpty()) {
			Tree.Node node = q.remove();	
			sum += node.value;

			if(node.left == null && node.right == null) {
				branchSums.add(node.value);
			}

			if(node.left != null) {		
				q.add(node.left);
				node.left.value += node.value;
			}

			if(node.right != null) {
				q.add(node.right);
				node.right.value += node.value;
			}
		}

		return branchSums;
	}
	
	public static ArrayList<Integer> getBranchSums(Tree.Node root) {
		ArrayList<Integer> branchSums = new ArrayList<Integer>();	
		getBranchSums(root, 0, branchSums);	
		return branchSums;
	}
	
	public static void getBranchSums(Tree.Node root, int sum, ArrayList<Integer> branchSums) {
		sum += root.value;	

		if(root.left == null && root.right == null) {
			branchSums.add(sum);
			return;
		}	
		
		if(root.left != null) {
			getBranchSums(root.left, sum, branchSums);
		}

		if(root.right != null) {
			getBranchSums(root.right, sum, branchSums);
		}
				
	}
		
	public static void main(String args[]) {
		
		Tree tree = new Tree();

		tree.insert(new int[]{1,2,3,4,5,6,7,8,9,10});
			
		ArrayList<Integer> branchSums = getBranchSums(tree);
		
		for(int i=0; i<branchSums.size(); i++) {
			System.out.println(branchSums.get(i));
		}
	}
}
