class ReverseLinkedList {
	public static void reverse(List list) {
		list.tail = list.head;

		Node newNext = null;
		Node brokenNode = null;
		Node cur = list.head;
		
		while(true) {
			if(cur.next == null) {
				cur.next = newNext;
				list.head = cur;
				break;
			}	
			
			brokenNode = cur.next;
			cur.next = newNext;
			newNext = cur;

			cur = brokenNode;
		}
		
	}	

	public static void main(String args[]) {
		List list = new List();

		for(int i=0; i<=5; i++) {
			list.add(i);
		}

		reverse(list);
		System.out.println(list);
	}

}

class List {
	Node head, tail;
	
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

	List(Node head) {
		if(head == null) {
			return;
		}	

		this.head = head;
		Node cur = head;

		while(cur.next != null) {
			cur = cur.next;
		}
		tail = cur;
	}

	List() {
		head = tail = null;
	}
}

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
	}
}
