class ValidateSubsequence {

	public static boolean validateSubsequence(int arr[], int subseq[]) {
		int j=0;

		for(int i=0; i<arr.length; i++) {
			if(arr[i] == subseq[j]) {
				j++;
				if(j==subseq.length) {
					return true;
				}
			}
		}

		return false;
	}

	public static void main(String args[]) {
		
		int arr[] = {5,1,22,25,6,-1,8,10};
		int subseq[] = {1,6,-1,10};

		System.out.println(validateSubsequence(arr, subseq));

	}
}
