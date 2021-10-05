import {TreeNode, Tree} from "./Tree";

function getNodeDepths(tree: Tree): number {
	if(tree.root == null) {
		return 0;
	}

	return getNodeDepthsHelper(tree.root, 0);
}

function getNodeDepthsHelper(root: TreeNode, depth: number): number {
	if(root == null) {
		return 0;
	}

	return depth + getNodeDepthsHelper(root.left!, depth+1) + getNodeDepthsHelper(root.right!, depth+1);

}

(function main() {
	const tree: Tree = new Tree();

	for(let i=1; i<=9; i++) {
		tree.insertOne(i);
	}

	console.log(getNodeDepths(tree));
})();
