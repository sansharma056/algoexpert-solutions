class SubarraySort {
	public static int[] getSubarraySort(int arr[]) {
		int n = arr.length;
		int res[] = {-1,-1}; 
		
		int minOutOfOrder = Integer.MAX_VALUE;
		int maxOutOfOrder = Integer.MIN_VALUE;

		for(int i=0; i<n; i++) {
			boolean isOutOfOrder = false;

			if(i == 0) {
				if(arr[i] > arr[i+1]) {
					isOutOfOrder = true;
				}
			} else if(i == n-1) {
					if(arr[i-1] > arr[i]) {
						isOutOfOrder = true;
					}
			} else if(arr[i-1] > arr[i] || arr[i] > arr[i+1]) {
					isOutOfOrder = true;	
			}
			
			if(isOutOfOrder) {
					minOutOfOrder = Math.min(minOutOfOrder, arr[i]);
					maxOutOfOrder = Math.max(maxOutOfOrder, arr[i]);
			}
		}
		
		if(minOutOfOrder == Integer.MAX_VALUE) {
			return res;
		}
		
		for(int i=0; i<n; i++) {
			if(arr[i] > minOutOfOrder){
				res[0] = i;
				break;
			}
		}
	
		for(int i=n-1; i>=0; i--) {
			if(arr[i] < maxOutOfOrder) {
				res[1] = i;
				break;
			}
		}

		return res;
	}

	public static void main(String args[]) {
		int arr[] = {1,2,4,7,10,11,7,12,6,7,16,18,19};
		//int arr[] = {1,2,3,4};
		//int arr[] = {2,6,4,8,10,9,15};
		//int arr[] = {1};
		//int arr[] = {2,1};
		//int arr[] = {1,3,2,4,5};
		//int arr[] = {1,3,2,2,2};

		int res[] = getSubarraySort(arr);
		System.out.println( res[0] + " " + res[1] );
	}
}
