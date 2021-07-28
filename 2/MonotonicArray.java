class MonotonicArray {
	/* working but ugly solution
	static boolean isMonotonicArray(int a[]) {
		if(a.length <= 2) {
			return true;
		}

		int i = 1;	
		while(i < a.length && a[i] == a[i-1]) {
			i++;
		}
		
		int j = i;
		while(j < a.length && a[j] <= a[j-1]) {
			j++;
		}

		if(j == a.length) {
			return true;
		} else if(j != i) {
				return false;
		}
		
		while(j < a.length && a[j] >= a[j-1]) {
			j++;
		}
		
		if(j == a.length) {
			return true;
		} else if(j != i) {
				return false;
		}

		return false;
	}
	*/
	
	static boolean isMonotonicArray(int arr[]) {
		int n = arr.length;

		if(n <= 2) {
			return true;
		}

		boolean nonincreasing = true;
		boolean nondecreasing = true; 

		for(int i=1; i<n; i++) {
			if(arr[i] > arr[i-1]) {
				nonincreasing = false;
			}

			if(arr[i] < arr[i-1]) {
				nondecreasing = false;
			}
		}
		
		return nondecreasing || nonincreasing;
	}

	public static void main(String args[]) {
		int arr[] = {-1,-2,-3};
		System.out.println(isMonotonicArray(arr));
	}
}
