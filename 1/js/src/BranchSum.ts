import {BSTNode, BST} from "./BST";
	
function getBranchSums(bst: BST): number[] {
	let res: number[]= [];
	res.push(10);

	return res;
}

(function main() {
	const bst = new BST();

	bst.insertMany([10, 5, 15, 2, 6, 13, 22, 14]);

	console.log(getBranchSums(bst));
})();
