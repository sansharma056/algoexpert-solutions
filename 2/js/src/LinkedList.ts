class ListNode {
	data: number
	next: ListNode | null

	constructor(data: number) {
		this.data = data;
		this.next = null;
	}
}

class List {
	head: ListNode | null
	tail: ListNode | null

	constructor() {
		this.head = this.tail = null;
	}

	insertEnd(data: number) {
		const newNode = new ListNode(data);

		if(this.head == null) {
			this.head = this.tail = newNode;
			return;
		}

		this.tail.next = newNode;
		this.tail = newNode;
	}

	deleteFromEnd(pos: number) {
		if(this.head == null) {
			return;
		}

		let first, second;
		first = second = this.head;

		while(pos > 0) {
			second = second.next;
			pos--;
		}

		if(second == null) {
			this.head = this.head.next;
			return;
		}

		while(second.next != null) {
			first = first.next;
			second = second.next;
		}

		first.next = first.next.next;
	}

	toString(): string {
		let res = "";
		let cur = this.head;

		while(cur != null) {
			res += cur.data + " ";
			cur = cur.next;
		}

		return res;
	}
}

(function main() {
	const list = new List;

	for(let i=0; i<=9; i++) {
		list.insertEnd(i);
	}

	list.deleteFromEnd(4);

	console.log(list.toString());
})();
