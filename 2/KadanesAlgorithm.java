class KadanesAlgorithm {
	public static int kadanesAlgorithm(int arr[]) {
		int max = arr[0];
		int maxTillHere = arr[0];	

		for(int i=1; i<arr.length; i++) {
			maxTillHere = Math.max(maxTillHere+arr[i], arr[i]);
			max = Math.max(max, maxTillHere);
		}
		
		return max;
	}

	public static void main(String args[]) {
		int arr[] = {3,5,-9,1,3,-2,3,4,7,2,-9,6,3,1,-5,4};
		System.out.println(kadanesAlgorithm(arr));
	}
}
