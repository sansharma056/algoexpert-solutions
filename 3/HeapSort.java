import java.util.Arrays;

class Heapsort {
	public static void sort(int arr[]) {
		buildHeap(arr);	
		
		int size = arr.length;
		
		while(size > 0) {
			swap(0, size-1, arr);
			size--;
			siftDown(0, size, arr);
		}
	}

	private static void buildHeap(int arr[]) {
		for(int i=(arr.length-1)/2; i>=0 ; i--)	{
			siftDown(i, arr.length, arr);
		}
	}
	private static void swap(int i, int j, int arr[]) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void siftDown(int i, int size, int arr[]) {
		while(2*i + 1 < size) {
			int left = 2*i+1;
			int right = 2*i+2;

			int selected = left;
			
			if(right < size) {
				if(arr[right] > arr[left]) {
					selected = right;
				}	
			}
			
			if(arr[i] > arr[selected]) {
				return;
			}
			
			swap(i, selected, arr);
			i = selected;
		}	
	}

	public static void main(String args[]) {
		int arr[] = {8,5,2,9,5,6,3};
		sort(arr);
		System.out.println(Arrays.toString(arr));	
	}
}
