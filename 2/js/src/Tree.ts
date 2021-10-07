class TreeNode {
	data: number
	left: TreeNode | null
	right: TreeNode | null

	constructor(data: number) {
		this.data = data;
		this.left = this.right = null;
	}
}

class Tree {
	root: TreeNode | null

	constructor(root ?: TreeNode) {
		if(root != undefined) {
			this.root = root;
		} else {
			this.root = null;
		}
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
			const cur = queue.shift()!;

			if(cur.left == null) {
				cur.left = newNode;
				return;
			} else {
				queue.push(cur.left);
			}

			if(cur.right == null) {
				cur.right = newNode;
				return;
			} else {
				queue.push(cur.right);
			}
		}
	}

	insertMany(dataArr: number[]) {
		dataArr.forEach(this.insertOne);
	}
}

export {TreeNode, Tree};
