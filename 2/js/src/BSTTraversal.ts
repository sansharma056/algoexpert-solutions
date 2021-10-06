import {BSTNode, BST} from "./BST";

function preorder(bst: BST): number[] {
	let res: number[] = [];

	preorderHelper(bst.root, res);

	return res;
}

function preorderHelper(root: BSTNode | null, result: number[]) {
	if(root == null) {
		return;
	}

	result.push(root.data);
	preorderHelper(root.left, result);
	preorderHelper(root.right, result);
}

function inorder(bst: BST): number[] {
	let res: number[] = [];

	inorderHelper(bst.root, res);

	return res;
}

function inorderHelper(root: BSTNode | null, result: number[]) {
	if(root == null) {
		return;
	}

	inorderHelper(root.left, result);
	result.push(root.data);
	inorderHelper(root.right, result);
}

function postorder(bst: BST): number[] {
	let res: number[] = [];

	postorderHelper(bst.root, res);

	return res;
}

function postorderHelper(root: BSTNode | null, result: number[]) {
	if(root == null) {
		return;
	}

	postorderHelper(root.left, result);
	postorderHelper(root.right, result);
	result.push(root.data);
}

// (function main() {
// 	const bst = new BST();
// 	bst.insertMany([10,5,15,2,5,1,22]);

// 	console.log("inorder:", inorder(bst));
// 	console.log("preorder:", preorder(bst));
// 	console.log("postorder:", postorder(bst));
// })();

export {preorder, inorder, postorder};
