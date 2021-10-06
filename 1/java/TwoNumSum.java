import java.util.HashMap;

class TwoNumSum {

public static int partition(int arr[], int start, int end) {
	int pivot = arr[end];	
	int pi = start -1;	

	for(int i=start; i<end-1; i++) {
		if(arr[i] < pivot) {
			pi++;

			int t = arr[i];
			arr[i] = arr[pi];
			arr[pi] = t;
		}
	}
	
	int t = arr[end];
	arr[end] = arr[pi+1];
	arr[pi+1] = arr[end];

	return pi+1;
}

public static void quickSort(int arr[], int start, int end) {
	if(start<end) {
		int pi = partition(arr, start, end);
		quickSort(arr, start, pi-1);
		quickSort(arr, pi+1, end);
	}
}

	public static void main(String args[]) {
		
		// HashMap<Integer, Boolean> table = new HashMap<Integer, Boolean>();

		int arr[] = {3, 5, -4, 8, 11, 1, -1, 6};
		int sum = 10;
		quickSort(arr, 0, arr.length-1);
					
		for(int x: arr) {
			int y = sum-x;
			if(table.get(y) == null) {
				table.put(x, true);
			} else {
				System.out.println(String.format("%d,%d",x,y));
				break;
			}
		}	
		
		int leftPtr = 0;
		int rightPtr = arr.length-1;

		for(int i=0; i<arr.length; i++) {
			if( arr[leftPtr] + arr[rightPtr] == sum ) {
				System.out.println(String.format("%d,%d",arr[leftPtr],arr[rightPtr]));	
				break;
			} else if(arr[leftPtr] + arr[rightPtr] < sum) {
				leftPtr++;
			} else {
				rightPtr--;
			}
		}

	}
}
