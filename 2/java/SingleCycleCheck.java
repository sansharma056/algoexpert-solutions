class SingleCycleCheck {
	public static boolean isSingleCycle(int arr[]) {
		int visited = 0;
		int n = arr.length;
		int current = 0;

		do {
			current = (current + arr[current]) % n;

			if(current < 0) {
				current = (n+current);
			}

			visited++;
		} while( current != 0 && visited <= n);
		
		if(current != 0 || visited < n) {
			return false;
		} 

		return true;
	}	

	public static void main(String args[]) {
		int arr[] = {2,3,1,-4,-4,2};
		System.out.println(isSingleCycle(arr));
	}
}
