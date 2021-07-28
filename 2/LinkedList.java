public class LinkedList {
	Node head = null;

	class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public void insert(int data) {
		Node cur = this.head;

		if(cur == null) {
			this.head = new Node(data);
			return;
		}
		
		while(cur.next != null) {
			cur = cur.next;
		}
		
		cur.next = new Node(data);
	}

	public void print() {
		Node cur = this.head;

		if(cur != null) {
			while(cur != null) {
				System.out.print(cur.data + " ");
				cur = cur.next;	
			}	
		} 

		System.out.println();
	}
	
	public void deleteFromEnd(int n) {
		if(this.head == null) {
			return;
		}

		Node first = this.head;
		Node second = this.head;

		while(n > 1 && second.next != null) {
			second = second.next;
			n--;
		}
		
		if(second.next == null) {
			this.head = this.head.next;
			return;
		}

		while(second.next.next != null) {
			first = first.next;
			second = second.next;
		}
		
		first.next = first.next.next;
	}

	public static void main(String args[]) {
		LinkedList list = new LinkedList();
		int n = 4;

		for(int i=0; i<=9; i++) {
			list.insert(i);
		}
		
		list.print();
		list.deleteFromEnd(n);
		list.print();
	}
}
