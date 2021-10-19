class MergeLinkedList {
	// Time Complexity O(n+m), Space Complexity O(1)
	public static List mergeAlt(List list1, List list2) {
		if(list1.head == null) {
			return list2;
		}

		if(list2.head == null) {
			return list1;
		}

		Node p1 = list1.head, p2 = list2.head, prev = null;

		while(p1 != null && p2 != null) {
			if(p1.data < p2.data) {
				prev = p1;
				p1 = p1.next;
			}	else {
				if(prev != null) {
					prev.next = p2;
				}
				prev = p2;
				p2 = p2.next;
				prev.next = p1;
			}
		}

		if(prev != null) {
			prev.next = p2;
		}

		return list1.head.data < list2.head.data ? list1 : list2;
	}

	// Time Complexity O(n+m), Space Complexity O(n+m)
	// Create new list
	public static List merge(List list1, List list2) {
		List mergedList = new List();

		Node ptr1 = list1.head;
		Node ptr2 = list2.head;

		while(ptr1 != null && ptr2 != null) {
			if(ptr1.data < ptr2.data) {
				mergedList.add(ptr1.data);
				ptr1 = ptr1.next;
			} else {
					mergedList.add(ptr2.data);
					ptr2 = ptr2.next;
			}
		}

		while(ptr1 != null) {
			mergedList.add(ptr1.data);
			ptr1 = ptr1.next;
		}

		while(ptr2 != null) {
			mergedList.add(ptr2.data);
			ptr2 = ptr2.next;
		}

		return mergedList;
	}

	public static void main(String args[]) {
		List list1 = new List();
		List list2 = new List();

		for(int x : new int[]{2,6,7,8}) {
			list1.add(x);
		}

		for(int x : new int[]{1,3,4,5,9,10}) {
			list2.add(x);
		}

		System.out.println(mergeAlt(list1, list2));
		// System.out.println(merge(list1, list2));
	}
}

class List {
	Node head, tail;

	List() {
		head = tail = null;
	}

	List(Node head) {
		this.head = tail = head;

		while(tail.next != null) {
			tail = tail.next;
		}
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();

		Node cur = head;
		while(cur != null) {
			str.append(cur.data);
			str.append(' ');
			cur = cur.next;
		}

		return str.toString();
	}

	void add(int data) {
		if(head == null) {
			head = tail = new Node(data);
			return;
		}

		tail.next = new Node(data);
		tail = tail.next;
	}

}

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		next = null;
	}
}
