import { ListNode, LinkedList } from "./LinkedList";

function findLoop(head: ListNode): number {
	let first, second;
	first = second = head;

	first = first.next;
	second = second.next!.next;

	while (first != second) {
		first = first!.next;
		second = second!.next!.next;
	}

	first = head;

	while (first != second) {
		first = first!.next;
		second = second!.next;
	}

	return first!.data;
}

(function main() {
	const list = new LinkedList();

	for (let i = 0; i <= 9; i++) {
		list.insertEnd(i);
	}

	list.tail!.next = list.getByValue(4);

	console.log(findLoop(list.head!));
})();
