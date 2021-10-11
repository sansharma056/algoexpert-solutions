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

	constructor() {
		this.root = null;
	}

	insertOne(data: number) {
		const node = new TreeNode(data);

		if(this.root == null) {
			this.root = node;
			return;
		}

		const queue: TreeNode[] = [];
		queue.push(this.root);

		while(queue.length != 0) {
			const cur = queue.shift()!;

			if(cur.left == null) {
				cur.left = node;
				return;
			} else {
				queue.push(cur.left);
			}

			if(cur.right == null) {
				cur.right = node;
				return;
			} else {
				queue.push(cur.right);
			}
		}
	}
}

export {TreeNode, Tree};
