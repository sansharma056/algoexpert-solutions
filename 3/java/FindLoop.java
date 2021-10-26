class FindLoop {
	public static int findLoop(Node head) {
		Node first, second;
		
		first = head.next;
		second = head.next.next;

		while(first != second) {
			first = first.next;
			second = second.next.next;
		}
		
		first = head;

		while(first != second) {
			first = first.next;
			second = second.next;
		}

		return first.data;
	} 

	public static void main(String args[]) {
		List list = new List();

		for(int i=0; i<=2; i++) {
			list.add(i);
		}
		
		for(int i=4; i<=9; i++) {
			list.add(i);
		}
		
		Node loop = list.search(4);
		list.tail.next = loop;
		
		System.out.println(findLoop(list.head));
	}
}

class List {
	Node head, tail = null;
	
	Node search(int data) {
		Node cur = head;

		while(cur != null) {
			if(cur.data == data) {
				return cur;
			}

			cur = cur.next;
		}

		return null;
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
	}
}
