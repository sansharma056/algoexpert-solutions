class ShiftLinkedList {
	public static void shiftLinkedList(List list, int k) {
		int n=0;
		Node cur = list.head;
		while(cur!= null) {
			n++;
			cur = cur.next;
		}
		
		k = k % n;
		
		if(k == 0) {
			return;
		}
		
		cur = list.head;
		Node newHeadInNext = null;
		for(int i=1; i<n; i++) {
			if(i == n-k) {
				newHeadInNext = cur;
			}
			cur = cur.next;	
		}
		
		cur.next = list.head;
		list.head = newHeadInNext.next;
		newHeadInNext.next = null;
	}

	public static void main(String args[]) {
		List list = new List();
		int k = 2;
		for(int i=0; i<=5; i++) {
			list.add(i);
		}
			
		shiftLinkedList(list, k);
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
