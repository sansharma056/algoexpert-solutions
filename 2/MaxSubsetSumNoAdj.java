class MaxSubsetSumNoAdj {
	
	public static int getMaxSum(int arr[]) {
		int n = arr.length;	
		int maxSums[] = new int[2];	
		
		maxSums[0] = arr[0];
		maxSums[1] = Math.max(arr[0], arr[1]);
		/*
		for(int i = 2; i<n; i++) {
			maxSums[i] = Math.max(maxSums[i-1], maxSums[i-2] + arr[i] );
		}
	*/	
		for(int i=2; i<n; i++) {
			int temp = maxSums[1];
			maxSums[1] = Math.max(temp, maxSums[0] + arr[i]); 
			maxSums[0] = temp;
		}

		return maxSums[1];
	};

	public static void main(String args[]) {
		int arr[] = {7,10,12,7,9,14};

		System.out.println(getMaxSum(arr));
	}
}
