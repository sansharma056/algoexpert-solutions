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

	constructor(head?: ListNode | null) {
		if (head == undefined) {
			this.head = this.tail = null;
			return;
		}

		this.head = this.tail = head;

		while (this.tail != null) {
			this.tail = this.tail.next;
		}
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

	toString() {
		let res = "";
		let cur = this.head;

		while (cur != null) {
			res += cur.data + " ";
			cur = cur.next;
		}

		return res;
	}
}

export { ListNode, LinkedList };
