class ListNode {
	value: number;
	prev: ListNode | null;
	next: ListNode | null;

	constructor(value: number) {
		this.value = value;
		this.prev = this.next = null;
	}
}

class List {
	head: ListNode | null;
	tail: ListNode | null;

	constructor() {
		this.head = this.tail = null;
	}

	setHead(node: ListNode) {
		if (this.head == null) {
			this.head = this.tail = node;
			return;
		}

		this.head.prev = node;
		node.next = this.head;
		this.head = node;
	}

	setTail(node: ListNode) {
		if (this.tail == null) {
			this.setHead(node);
			return;
		}
	}

	insertBefore(node: ListNode, nodeToInsert: ListNode) {
		if (this.head == nodeToInsert && this.tail == nodeToInsert) {
			return;
		}

		this.remove(nodeToInsert);
		nodeToInsert.prev = node.prev;
		nodeToInsert.next = node;

		if (node.prev == null) {
			this.head = nodeToInsert;
		} else {
			node.prev.next = nodeToInsert;
		}

		node.prev = nodeToInsert;
	}

	insertAfter(node: ListNode, nodeToInsert: ListNode) {
		if (this.head == nodeToInsert && this.tail == nodeToInsert) {
			return;
		}

		this.remove(nodeToInsert);
		nodeToInsert.prev = node;
		nodeToInsert.next = node.next;

		if (node.next == null) {
			this.tail = nodeToInsert;
		} else {
			node.next.prev = nodeToInsert;
		}

		node.next = nodeToInsert;
	}

	insertAtPosition(position: number, nodeToInsert: ListNode) {
		if (position == 1) {
			this.setHead(nodeToInsert);
		}

		let cur = this.head;
		let currentPosition = 1;

		while (cur != null && currentPosition != position) {
			cur = cur.next;
			currentPosition++;
		}

		if (cur != null) {
			this.insertBefore(cur, nodeToInsert);
		} else {
			this.setTail(nodeToInsert);
		}

	}

	removeNodeWithValue(value: number) {
		let cur = this.head;

		while (cur != null) {
			if (cur.value == value) {
				this.remove(cur);
				return;
			}

			cur = cur.next;
		}
	}

	remove(node: ListNode) {
		if (this.head == node) {
			this.head = this.head.next;
		} else if (this.tail == node) {
			this.tail = this.tail.prev;
		}

	}

	removeBindings(node: ListNode) {
		if (node.prev != null) {
			node.prev.next = node.next;
		}

		if (node.next != null) {
			node.next.prev = node.prev;
		}

		node.prev = null;
		node.next = null;
	}


	containsNodeWithValue(value: number): ListNode | null {
		let node = this.head;

		while (node != null) {
			if (node.value == value) {
				return node;
			}

			node = node.next;
		}

		return null;
	}
}

(function main() {})();
