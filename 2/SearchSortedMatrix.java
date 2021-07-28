class SearchSortedMatrix {
	public static int[] search(int matrix[][], int x) {
		int r = matrix.length;
		int c = matrix[0].length;
		
		int i = 0;
		int j = c-1;
		
		while(i < r && j >= 0) {
			if(matrix[i][j] < x) {
					i++;
			} else if(matrix[i][j] > x) {
					j--;	
			} else {
					return new int[]{i,j};
			}
		}

		return new int[]{-1,-1};
	}	

	public static void main(String args[]) {
		int matrix[][] = {
			{1,4,7,12,15,1000},
			{2,5,19,31,32,1001},
			{3,8,24,33,35,1002},
			{40,41,42,44,45,1003},
			{99,100,103,106,128,1004}
		};	

		int x = 44;	
		int coordinates[] = search(matrix, x);
		for(int i : coordinates) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
