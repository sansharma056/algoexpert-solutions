import {BSTNode, BST} from "./BST";
import {preorder} from "./BSTTraversal";

function generateMinHeightBST(list: number[]): BST {
	const bst = new BST();

	bst.root = generateMinHeightBSTHelper(list, 0, list.length-1);

	return bst;
}

function generateMinHeightBSTHelper(list: number[], first: number, last: number): BSTNode | null {
	if(first > last) {
		return null;
	}

	const mid = Math.floor((first+last) / 2);

	const node = new BSTNode(list[mid]);
	node.left = generateMinHeightBSTHelper(list, first, mid-1);
	node.right = generateMinHeightBSTHelper(list, mid+1, last);

	return node;
}

(function main() {
	const list = [1,2,5,7,10,13,14,15,22];

	const bst: BST = generateMinHeightBST(list);

	console.log(preorder(bst));
})();
