class BinarySearch {

	public static int binarySearch(int array[], int x) {
		return binarySearchHelperItr(array, x);	
	}

	public static int binarySearchHelperItr(int array[], int x) {
		int start = 0;
		int end = array.length-1;

		while(start <= end) {
			int mid = (start+end)/2;

			if(x > array[mid]) {
				start = mid+1;
			} else if(x < array[mid]) {
				end = mid-1;
			} else {
				return mid+1;
			}
		}
		
		return -1;
	}

	public static int binarySearchHelperRec(int array[], int start, int end, int x) {
		if(start <= end) {
			int mid = (start+end)/2;
			
		
			if(x > array[mid]) {
				return binarySearchHelperRec(array, mid+1, end, x);
			} else if(x < array[mid]) {
				return binarySearchHelperRec(array, start, mid-1, x);
			} else {
				return mid+1;
			}
		}

		return -1;
	}

	public static void main(String args[]) {
		int array[] = new int[]{0,1,21,33,45,61,71,72,73};
		int x = 33;
		
		System.out.println(binarySearch(array, x));

	}
}
