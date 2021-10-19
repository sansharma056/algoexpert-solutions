import { LinkedList } from "./LinkedList";

function shiftLinkedList(list: LinkedList, k: number) {
	let n = 0;

	let cur = list.head;
	while (cur != null) {
		n++;
		cur = cur.next;
	}

	k = k % n;

	if (n <= 1 || k == 0) {
		return;
	}

	cur = list.head;
	for (let i = 0; i < n - k - 1; i++) {
		cur = cur!.next;
	}

	const newHead = cur!.next;
	cur!.next = null;

	cur = newHead;
	while (cur!.next != null) {
		cur = cur!.next;
	}

	cur!.next = list.head;
	list.head = newHead;
}

(function main() {
	const list = new LinkedList();
	const k = 2;

	for (let i = 0; i <= 5; i++) {
		list.insertEnd(i);
	}

	shiftLinkedList(list, k);
	console.log(list.toString());
})();
