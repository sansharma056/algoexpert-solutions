import { ListNode, LinkedList } from "./LinkedList";

function reverseLinkedList(list: LinkedList) {
	let prev: ListNode | null = null;
	let cur = list.head;

	while (cur != null) {
		const next = cur.next;
		cur.next = prev;
		prev = cur;
		cur = next;
	}

	[list.head, list.tail] = [list.tail, list.head];
}

(function main() {
	const list = new LinkedList();

	for (let i = 0; i <= 5; i++) {
		list.insertEnd(i);
	}

	reverseLinkedList(list);

	console.log(list.toString());
})();
