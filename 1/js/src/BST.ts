class BSTNode {
	data: number;
	left: BSTNode | null;
	right: BSTNode | null;

	constructor(data: number) {
		this.data = data;
		this.left = this.right = null;
	}
}

class BST {
	root: BSTNode | null;

	constructor() {
		this.root = null;
	}

	insertOne(data: number) {
		const newNode = new BSTNode(data);	

		let parentNode: BSTNode | null = null;
		let currentNode: BSTNode | null = this.root; 
		let isLeftNode  = false;	

		while(currentNode != null) {
			parentNode = currentNode;
			if(data < currentNode.data) {
				isLeftNode = true;	
				currentNode = currentNode.left;
			} else {
				isLeftNode = false;
				currentNode = currentNode.right;
			}
		}
		if(parentNode == null) {
			this.root = newNode;
		} else if(isLeftNode) {
			parentNode.left = newNode;
		}	else {
			parentNode.right = newNode;
		}
	}

	insertMany(dataArr: number[]) {
		for(const data of dataArr) {
			this.insertOne(data);
		}
	}
}

export {BSTNode, BST};
