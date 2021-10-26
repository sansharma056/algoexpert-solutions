class ShiftedBinarySearch {
	public static int find(int arr[], int x) {
		int first = 0;
		int last = arr.length-1;
		
		while(first <= last) {
			int mid = (first+last)/2;

			if(x == arr[mid]) {
				return mid;
			} 
		
			if(arr[first] <= arr[mid]) {
				if(x >= arr[first] && x < arr[mid]) {
					last = mid-1;
				} else {
						first = mid+1;
				}
			} else if(arr[mid] <= arr[last]) {
					if(x > arr[mid] && x <= arr[last]) {
						first = mid-1;
					}	else {
							last = mid+1;
					}
			}
		}

		return -1;
	}

	public static void main(String args[]) {
		int arr[] = {4, 5, 6, 7, 0, 1, 2};	
		System.out.println(find(arr, 0));
	}
}
