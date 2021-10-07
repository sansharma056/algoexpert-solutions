import {TreeNode, Tree} from "./Tree";
import {preorder} from "./BSTTraversal";

function invertBinaryTree(tree: Tree) {
	invertBinaryTreeHelper(tree.root);
}

function invertBinaryTreeHelper(root: TreeNode | null) {
	if(root == null) {
		return null;
	}

	[root.left, root.right]	 = [root.right, root.left];

	invertBinaryTreeHelper(root.left);
	invertBinaryTreeHelper(root.right);
}

(function main() {
	const tree = new Tree();

	for(let i=1; i<=9; i++) {
		tree.insertOne(i);
	}

	invertBinaryTree(tree);
	console.log(preorder(tree));
})();
