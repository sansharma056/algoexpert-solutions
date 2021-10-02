class TreeNode {
	data: number;
	left: TreeNode | null;
	right: TreeNode | null;

	constructor(data: number) {
		this.data = data;
		this.left = this.right = null;
	}
}

class Tree {
	root: TreeNode | null;
	
	constructor() {
		this.root = null;
	}

	insertOne(data: number) {
		const newNode = new TreeNode(data);
		
		if(this.root == null) {
			this.root = newNode;
			return;
		}

		let queue: TreeNode[] = [];
		queue.push(this.root);

		while(queue.length != 0) {
			const currentNode: TreeNode = queue.shift()!;
			
			if(currentNode.left == null) {
				currentNode.left = newNode;
				return;
			} else {
				queue.push(currentNode.left);
			}
			
			if(currentNode.right == null) {
				currentNode.right = newNode;
				return;
			} else {
				queue.push(currentNode.right);
			}
		}
	}

	insertMany(dataArr: number[]) {
		for(const data of dataArr) {
			this.insertOne(data);
		}
	}
}

export {TreeNode, Tree};
