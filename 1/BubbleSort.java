class BubbleSort {
	
	public static void bubbleSort(int array[]) {
		int n = array.length;

		for(int i=0; i<n-1; i++) {
			boolean flag = true;
			for(int j=0; j<n-i-1; j++) {
				if(array[j+1] < array[j]) {
					flag = false;
					int t = array[j+1];
					array[j+1] = array[j];
					array[j] = t;
				}
			}
			if(flag) {
				break;
			}
		}

	}

	public static void main(String args[]) {
		int array[] = new int[]{8,5,2,9,5,6,3};		
		
		bubbleSort(array);
		
		for(int i : array) {
			System.out.print(String.format("%d \t", i));
		}

		System.out.println();
	}
}
