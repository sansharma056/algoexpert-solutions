import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class MinHeap {
	private List<Integer> heap;

	MinHeap() {
		this.heap = new ArrayList<>();
	}	
	
	public void buildHeap(List<Integer> arr) {
		this.heap = arr;
		
		for(int i=this.heap.size()/2-1; i>=0; i--) {
			siftDown(i);
		}

	}	

	public void insert(int data) {
		this.heap.add(data);
		this.siftUp(heap.size()-1);
	}
	
	public int delete() {
		int deleted = heap.get(0);
		
		heap.set(0, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		siftDown(0);

		return deleted;
	}
	
	private void siftUp(int index) {
		if(index == 0) {
			return;
		}

		int parent = (int)Math.floor((index-1)/2);

		while(heap.get(parent) > heap.get(index)) {
			int temp = heap.get(parent);
			heap.set(parent, heap.get(index));
			heap.set(index, temp);
			
			index = parent;
			parent = (int)Math.floor((index-1)/2);
		}
	}
	
	private void siftDown(int index) {
		while(index*2+1 < heap.size()) {

			int leftChildIndex = index*2+1;
			int rightChildIndex = index*2+2;
			int minChildIndex = getMinChildIndex(leftChildIndex, rightChildIndex); 

			int temp = heap.get(index);	
			
			if(temp > heap.get(minChildIndex)) {
				heap.set(index, heap.get(minChildIndex));	
				heap.set(minChildIndex, temp);
				index = minChildIndex;
			} else {
					break;
			}
			
		}
	}
	
	private int getMinChildIndex(int index1, int index2) {
		if(index2 == this.heap.size()) {
			return index1;
		}

		if(this.heap.get(index1) < this.heap.get(index2)) {
			return index1;
		} else {
				return index2;
		}
	}

	public void print() {
		for(int i : this.heap) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void main(String args[]) {
		MinHeap mh = new MinHeap(); 
		List<Integer> arr = new ArrayList<Integer>(Arrays.asList(new Integer[]{30,102,23,17,18,9,44,12,31}));
		
		mh.buildHeap(arr);
		mh.print();
		
		/*
			 int arr[] = {8,12,23,17,31,30,44,102,18};

			 for(int i : arr) {
			 mh.insert(i);
			 }
			 mh.insert(9);
			 mh.delete();
			 mh.print();
	*/
	}
}
