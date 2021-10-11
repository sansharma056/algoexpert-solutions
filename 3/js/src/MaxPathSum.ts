import {TreeNode, Tree} from "./Tree";

function getMaxPathSum(tree: Tree): number {
	return Math.max(...getMaxPathSumHelper(tree.root));
}

function getMaxPathSumHelper(root: TreeNode | null): [number, number] {
	if(root == null) {
		return [0,0];
	}

	const data = root.data;
	const [leftPathSum, leftBranchSum] = getMaxPathSumHelper(root.left);
	const [rightPathSum, rightBranchSum] = getMaxPathSumHelper(root.right);

	const maxChildBranch = Math.max(leftBranchSum, rightBranchSum);
	const maxBranchSum = Math.max(maxChildBranch + data, data);

	const maxSumWithRoot  = Math.max(data + leftBranchSum + rightBranchSum, maxBranchSum);

	const maxPathSum = Math.max(leftPathSum, rightPathSum, maxSumWithRoot);

	return [maxPathSum, maxBranchSum];
}

(function main() {
	const tree = new Tree();

	for(let i=1; i<=7; i++) {
		tree.insertOne(i);
	}

	console.log(getMaxPathSum(tree));
})();
