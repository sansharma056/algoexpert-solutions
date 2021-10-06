import {BSTNode, BST} from "./BST";

function isValidBST(bst: BST): boolean {
	return isValidBSTHelper(bst.root, Number.NEGATIVE_INFINITY, Number.POSITIVE_INFINITY);
}

function isValidBSTHelper(root: BSTNode | null, min: number, max: number): boolean {
	if(root == null) {
		return true;
	}

	if(root.data > max && root.data < min) {
		return false;
	}

	return isValidBSTHelper(root.left, min, root.data) && isValidBSTHelper(root.right, root.data, max);
}

(function main() {
	const bst = new BST();
	bst.insertMany([10,5,2,5,1,15,13,22,14]);
	console.log(isValidBST(bst));
})();
