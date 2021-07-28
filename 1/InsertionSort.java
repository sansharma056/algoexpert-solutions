class InsertionSort {
	
	public static void insertionSort(int array[]) {
		int n = array.length;
		
		for(int i=1; i<n; i++) {
			int key = array[i];
			
			int j=i-1;
			while(j>=0 && key < array[j]) {
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = key;
		}

	}
	
	public static void main(String args[]) {
		int array[] = new int[]{8,5,2,9,5,6,3};	
		
		insertionSort(array);

		for(int i : array) {
			System.out.print(String.format("%d \t", i));
		}

		System.out.println();
	}
}
