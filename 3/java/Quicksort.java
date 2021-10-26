import java.util.Arrays;

class Quicksort {
	public static void sort(int start, int end, int arr[]) {
		if(start <= end) {
			int pivotIdx = partition(start, end, arr);	
			sort(start, pivotIdx-1, arr);
			sort(pivotIdx+1, end, arr);
		}
	}

	public static void sort(int arr[]) {
		sort(0, arr.length-1, arr);	
	}
	
	public static void swap(int i, int j, int arr[]) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static int partition(int start, int end, int arr[]) {
		int pivotIdx = start;
		int left = start + 1;
		int right = end;

		while(left <= right) {
			if(arr[left] > arr[pivotIdx] && arr[right] < arr[pivotIdx]) {
				swap(left, right, arr);
			}		
			
			if(arr[left] <= arr[pivotIdx]) {
				left++;
			}
			
			if(arr[right] >= arr[pivotIdx]) {
				right--;
			}
		}	

		swap(pivotIdx, right, arr);
		return right;
	}

	public static void main(String args[]) {
		int arr[] = {8,5,2,9,5,6,3};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
