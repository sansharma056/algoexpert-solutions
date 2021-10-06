import java.util.Stack;
import java.util.ArrayList;


class NodeDepth {


	class NodeWithDepth {
		public Tree.Node node;
		public int depth;

		NodeWithDepth(Tree.Node node, int depth) {
			this.node = node;
			this.depth = depth;
		}
	}

	public static int getNodeDepth(Tree.Node root, int depth) {
		if(root == null) {
			return 0;
		}

		return depth + getNodeDepth(root.left, depth+1) + getNodeDepth(root.right, depth+1);
	}
	
	public int getNodeDepth(Tree.Node root) {
		Stack<NodeWithDepth>stack = new Stack();	
		
		int nodeDepths = 0;
		
		NodeWithDepth rootNodeWithDepth = new NodeWithDepth(root, 0);

		stack.push(rootNodeWithDepth);

		while(!stack.empty()) {
			NodeWithDepth cur = stack.pop();	
			nodeDepths += cur.depth;	

			if(cur.node.left != null) {
				stack.push(new NodeWithDepth(cur.node.left, cur.depth+1));	
			}
			
			if(cur.node.right != null) {
				stack.push(new NodeWithDepth(cur.node.right, cur.depth+1));
			}	
		}

		return nodeDepths;
	}

	public static void main(String args[]) {
		
		Tree tree = new Tree();
		tree.insert(new int[]{1,2,3,4,5});
		
		System.out.println(new NodeDepth().getNodeDepth(tree.getRoot()));
	}
}
