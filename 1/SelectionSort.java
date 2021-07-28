class SelctionSort {
	
	public static void selectionSort(int array[]) {
		int n = array.length;
		
		for(int i=0; i<n-1; i++) {
			int minIdx = i;
			for(int j=i+1; j<n; j++) {
				if(array[j] < array[minIdx]) {
					minIdx = j; 
				}
			}
			
			int t = array[i];
			array[i] = array[minIdx];
			array[minIdx] = t;
		}
	}

	public static void main(String args[]) {
		int array[] = new int[]{8,5,2,9,5,6,3};
	
		selectionSort(array);
		
		for(int i : array) {
			System.out.print(String.format("%d\t", i));
		}
		
		System.out.println();
	}
}
