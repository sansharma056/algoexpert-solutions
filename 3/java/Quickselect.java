class Quickselect {
	public static void swap(int i, int j, int arr[]) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static int quickSelect(int arr[], int k) {
		int left = 1;
		int right = arr.length-1;
		
		while(true) {
			int pivotIdx = left-1;		
			
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

			if(right == k-1) {
				return arr[right];
			} else if(right < k-1) {
					left = right+2; 	
					right = arr.length-1;
			} else {
					left = 1;
					right -= 1;
			}
		}
	}

	public static void main(String args[]) {
		int arr[] = {8,5,2,9,7,6,3};
		int k = 3;
		
		System.out.println(quickSelect(arr, k));
	}
}
