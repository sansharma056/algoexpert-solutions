class MoveElementToEnd {
	static void moveElemToEnd(int arr[], int toMove) {

		int i = 0;
		int j = arr.length -1;

		while(i < j) {
			if(arr[i] == toMove) {
				while(arr[j] == toMove) {
					j--;	

					if(j <= i) {
						break;
					}
				}

				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				j--;
			}
			i++;
		}
	}

	public static void main(String args[]) {
		int arr[] = {2,1,2,2,2,3,4,2};
		int toMove = 2;

		moveElemToEnd(arr, 2);

		for(int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
