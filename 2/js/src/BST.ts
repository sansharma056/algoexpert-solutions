class BSTNode {
	data: number
	left: BSTNode | null
	right: BSTNode | null

	constructor(data: number) {
		this.data = data;
		this.left = this.right = null;
	}
}

class BST {
	root: BSTNode | null

	constructor() {
		this.root = null;
	}

	insertOne(data: number) {
		let isLeft = true;
		let parent: BSTNode | null = null;
		let cur:BSTNode | null = this.root;

		while(cur != null) {
			parent = cur;
			if(data < cur.data) {
				isLeft = true;
				cur = cur.left;
			}	else {
				isLeft = false;
				cur = cur.right;
			}
		}

		const newNode = new BSTNode(data);
		if(parent == null) {
			this.root = newNode;
		} else if(isLeft) {
			parent.left = newNode;
		} else {
			parent.right = newNode;
		}
	}

	insertMany(dataArr: number[]) {
		for(const data of dataArr) {
			this.insertOne(data);
		}
	}
}

export {BSTNode, BST};
