import {TreeNode, Tree} from "./Tree";
	
function getBranchSums(tree: Tree): number[] {
	let res: number[]= [];
	
	if(tree.root != null) {
		getBranchSumsHelper(tree.root, 0, res);
	}
	
	return res;
}

function getBranchSumsHelper(root: TreeNode, sum: number, res: number[]) {
	sum += root.data;

	if(root.left == null && root.right == null) {
		res.push(sum);	
		return;
	} 

	if(root.left != null) {
		getBranchSumsHelper(root.left, sum, res);
	} 

	if(root.right != null) {
		getBranchSumsHelper(root.right, sum, res);	
	}
}

(function main() {
	const tree = new Tree();
		
	for(let i=1; i<=10; i++) {
		tree.insertOne(i);
	}

	console.log(getBranchSums(tree));
})();
