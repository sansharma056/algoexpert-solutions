import { ListNode, LinkedList } from "./LinkedList";

function mergeLinkedList(
	list1: LinkedList,
	list2: LinkedList
): ListNode | null {
	if (list1.head == null) {
		return list2.head;
	}

	if (list2.head == null) {
		return list1.head;
	}

	let p1: ListNode | null = list1.head;
	let p2: ListNode | null = list2.head;
	let prev: ListNode | null = null;

	while (p1 != null && p2 != null) {
		if (p1.data < p2.data) {
			prev = p1;
			p1 = p1.next;
		} else {
			if (prev != null) {
				prev.next = p2;
			}

			prev = p2;
			p2 = p2.next;
			prev.next = p1;
		}
	}

	if (prev != null) {
		prev.next = p2;
	}

	return list1.head.data < list2.head.data ? list1.head : list2.head;
}

(function main() {
	const list1 = new LinkedList();
	const list2 = new LinkedList();

	[2, 6, 7, 8].forEach((i) => list1.insertEnd(i));
	[1, 3, 4, 5, 9, 10].forEach((i) => list2.insertEnd(i));

	const list3 = new LinkedList(mergeLinkedList(list1, list2));
	console.log(list3.toString());
})();
