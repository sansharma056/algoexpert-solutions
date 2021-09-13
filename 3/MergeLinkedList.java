class MergeLinkedList {
	// Time Complexity O(n+m), Space Complexity O(1)
	// Override list
	public static void mergeAlt(List list1, List list2) {
		Node ptr1=list1.head, ptr2=list2.head;
		
		Node ptr1Prev = null;

		while(ptr1 != null && ptr2 != null) {
			if(ptr1.data < ptr2.data) {
				ptr1Prev = ptr1;
				ptr1 = ptr1.next;
				continue;
			}
			
			Node ptr2Next = ptr2.next;

			if(ptr1 == list1.head) {
				list1.head = ptr2;
				ptr2.next = ptr1;
				ptr1Prev = list1.head;
				ptr2 = ptr2Next;
				continue;
			}
			
			ptr1Prev.next = ptr2;
			ptr2.next = ptr1;
			ptr1Prev = ptr2;
			ptr1 = ptr2; 
			ptr2 = ptr2Next;
		}
		

		while(ptr2 != null) {
			ptr1Prev.next = ptr2;
			ptr1Prev = ptr1Prev.next;
			ptr2 = ptr2.next;
		}
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
			list2.add(x);
		}
		
		for(int x : new int[]{1,3,4,5,9,10}) {
			list1.add(x);
		}
		
		System.out.println(merge(list1, list2));
		mergeAlt(list1, list2);
		System.out.println(list1);
	}	
}

class List {
	Node head, tail;

	List() {
		head = tail = null;
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
