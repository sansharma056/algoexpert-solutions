class DoublyLinkedList {
	Link head = null;
	Link tail = null;
	int count = 0;

	class Link {
		int value;
		Link prev = null;
		Link next = null;
		
		Link(int value) {
			this.value = value;
		}
	}

	Link setHead(int value) {
		if(head == null) {
			head = tail = new Link(value);
		} else {
				Link link = new Link(value);
				head.prev = link;
				link.next = head;
				head = link;
		}
		this.count++;
		return head;
	}

	Link setTail(int value) {
		if(head == null) {
			head = tail = new Link(value);
		} else {
				Link link = new Link(value);
				tail.next = link;
				link.prev = tail;
				tail = link;
			}
		this.count++;
		return tail;
	}
		
	Link search(int value) {
		Link temp = head;

		while(temp != null) {
			if(temp.value == value) {
				return temp;
			}
			temp = temp.next;
		}

		return null;
	}
		
	Link delete(Link deleted) {
		if(deleted == null) {
			return null;
		} else if(head == tail) {
				head = tail = null;
		} else if(deleted == head) {
				head.next.prev = null;
				head = head.next;
		} else if(deleted == tail) {
				tail.prev.next = null;
				tail = tail.prev;
		} else {
				deleted.prev.next = deleted.next;
				deleted.next.prev = deleted.prev;
		}
		
		this.count--;
		return deleted;
	}
	
	Link insertBefore(int value, Link beforeLink) {
		if(beforeLink == null) {
			return null;
		}

		Link newLink = new Link(value);
		this.count++;	

		if(head == null || head == beforeLink) {
			return setHead(value);
		} else {
				newLink.prev = beforeLink.prev;
				newLink.next = beforeLink;
				beforeLink.prev.next = newLink;
				beforeLink.prev = newLink;

				return newLink;
		}
	}

	Link insertAfter(int value, Link afterLink) {
		if(afterLink == null) {
			return null;
		}

		Link newLink = new Link(value);
		this.count++;

		if(tail == null || tail == afterLink) {
			return setTail(value);
		} else {
				newLink.prev = afterLink;
				newLink.next = afterLink.next;	
				afterLink.next.prev = newLink;
				afterLink.next = newLink;

				return newLink;
		}
	
	}	

	void display(String startFrom) {
		if(startFrom == "head") {
			Link temp = head;
			while(temp != null) {
				System.out.print(String.format("%d \t", temp.value));	
				temp = temp.next;
			}
		} else if(startFrom == "tail") {
				Link temp = tail;
				while(temp != null) {
					System.out.print(String.format("%d \t", temp.value));
					temp = temp.prev;
				}
		}
		System.out.println();
	}
	
	public static void main(String args[]) {
		DoublyLinkedList linkedList = new DoublyLinkedList();				
		
		linkedList.setTail(1);

		linkedList.display("head");
		linkedList.display("tail");
	}
}
