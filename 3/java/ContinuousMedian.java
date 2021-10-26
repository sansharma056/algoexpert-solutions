import java.util.List;
import java.util.ArrayList;
import java.util.function.BiFunction;

class ContinuousMedian {
	public static void main(String args[]) {
		int arr[] = {5, 10, 100, 200, 6, 13, 14};
		solve(arr);
	}
	
	public static boolean isMax(int a, int b) {
		return a > b;
	}
	
	public static boolean isMin(int a, int b) {
		return a < b;
	}

	public static void solve(int arr[]) {
		Heap upperHalf = new Heap((a,b) -> isMin(a,b));
		Heap lowerHalf = new Heap((a,b) -> isMax(a,b));
		
		for(int x : arr) {
			if(lowerHalf.isEmpty() || x < lowerHalf.peek()) {
				lowerHalf.add(x);	
			} else if(x > lowerHalf.peek()) {
				upperHalf.add(x);
			}
			
			balance(lowerHalf, upperHalf);
			System.out.print(getMedian(lowerHalf, upperHalf) + " ");
		}
		
		System.out.println();
	}
	
	public static void balance(Heap lowerHalf, Heap upperHalf) {
		int diff =	Math.abs(lowerHalf.size() - upperHalf.size());

		if(diff <= 1) {
			return;
		}
	
		boolean isLowerHalfImbalanced;
		
		if(lowerHalf.size() > upperHalf.size()) {
			isLowerHalfImbalanced = true;
		} else {
				isLowerHalfImbalanced = false;
		}

		if(isLowerHalfImbalanced) {
			upperHalf.add(lowerHalf.remove());
		} else {
				lowerHalf.add(upperHalf.remove());
		}
	}

	public static double getMedian(Heap lowerHalf, Heap upperHalf) {
		if(lowerHalf.size() == upperHalf.size()) {
			return (lowerHalf.peek()+ upperHalf.peek()) / 2.0;
		}							

		if(lowerHalf.size() > upperHalf.size()) {
			return lowerHalf.peek();
		}

		return upperHalf.peek();
	}
}

class Heap {
	List<Integer> heap;
	BiFunction<Integer, Integer, Boolean> compare;	
	
	Heap(BiFunction<Integer, Integer, Boolean> compare) {
		this.heap = new ArrayList<>();
		this.compare = compare;
	}
	
	boolean isEmpty()  {
		return heap.isEmpty();
	}

	int size() {
		return heap.size();
	}

	void swap(int i, int j) {
		int temp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, temp);
	}
	
	void siftUp(int i) {
		while(i > 0) {
			int parent =  (i-1)/2;	

			int idx;

			if(compare.apply(heap.get(i), heap.get(parent))) {
				idx = i;
			} else {
					idx = parent;
			}

			if(idx == parent) {
				return;
			}	
			
			swap(i, parent);
			i = parent;	
		}
	}

	void siftDown(int i) {
		while(2*i+1 < heap.size()) {
			int left = 2*i+1;
			int right = 2*i+2; 
			
			int idx;
			
			if(right >= heap.size() || compare.apply(heap.get(left), heap.get(right))) {
				idx = left;
			} else {
					idx = right;
			}
			
			if(compare.apply(heap.get(idx), heap.get(i))) {
				swap(i, idx);
				siftDown(i);
			} else {
					return;
			}
		}
	}

	void add(int data) {
		heap.add(data);
		siftUp(heap.size()-1);
	}

	int peek() {
		if(heap.isEmpty()) {
			try {
				throw new EmptyHeapException("Empty heap. Nothing to see here.");
			} catch (EmptyHeapException e) {
					e.printStackTrace();
			}
		}

		return heap.get(0);
	}

	int remove() {
		if(heap.size() == 0) {
			try {
				throw new EmptyHeapException("Empty Heap. Nothing to remove.");
			} catch (EmptyHeapException e) {
					e.printStackTrace();
			}
		}	

		swap(0, heap.size()-1);

		int deleted = heap.remove(heap.size()-1);
		siftDown(0);
		return deleted;
	}
}

class EmptyHeapException extends Exception {
	public EmptyHeapException(String message) {
		super(message);
	}
}
