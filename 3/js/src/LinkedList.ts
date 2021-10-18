class ListNode {
	data: number;
	next: ListNode | null;

	constructor(data: number) {
		this.data = data;
		this.next = null;
	}
}

class LinkedList {
	head: ListNode | null;
	tail: ListNode | null;

	constructor() {
		this.head = this.tail = null;
	}

	getByValue(data: number): ListNode | null {
		let cur = this.head;

		while (cur != null) {
			if (cur.data == data) {
				return cur;
			}

			cur = cur.next;
		}

		return null;
	}

	insertEnd(data: number) {
		const newNode = new ListNode(data);

		if (this.tail == null) {
			this.head = this.tail = newNode;
			return;
		}

		let cur = this.tail;
		while (cur.next != null) {
			cur = cur.next;
		}

		cur!.next = newNode;
		this.tail = newNode;
	}

	print() {
		let cur = this.head;

		while (cur != null) {
			console.log(cur.data);
			cur = cur.next;
		}
	}
}

export { ListNode, LinkedList };
