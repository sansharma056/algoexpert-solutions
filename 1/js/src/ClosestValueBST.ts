import {BSTNode, BST} from "./BST";

function getClosestValue(bst: BST, data: number): number {
	let currentNode: BSTNode | null = bst.root;
	let closest = Number.POSITIVE_INFINITY;

	while(currentNode != null) {
		if(Math.abs(closest - data) > Math.abs(currentNode.data - data)) {
			closest = currentNode.data;
		}	

		if(data < currentNode.data) {
			currentNode = currentNode.left;
		} else if(data > currentNode.data) {
			currentNode = currentNode.right;
		} else {
			return data;
		}
	}

	return closest;
}

(function main() {
	const bst = new BST();
	const data = 12;

	bst.insertMany([10, 5, 15, 2, 6, 13, 22, 14]);

	console.log(getClosestValue(bst, data));
})();
