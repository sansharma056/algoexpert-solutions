class SpiralTraverse {
	static void spiralTraverse(int arr[][]) {
		final int ROW = arr.length;
		final int COL = arr[0].length;
		final int N = ROW*COL; 
		
		int n = 0;
		
		int i=0;
		int j=0;
		

		int vRowStart = 0;
		int vRowEnd = ROW-1;

		int vColStart = 0;
		int vColEnd= COL-1;

		while(n != N) {
			i = vRowStart;
			j = vColStart;

			while(j <= vColEnd) {
				System.out.print(arr[i][j++] + " ");
				n++;	
			}

			vRowStart++;
			j = vColEnd;
			i = vRowStart;

			while(i <= vRowEnd) {
				System.out.print(arr[i++][j] + " ");
				n++;
			}

			vColEnd--;
			i = vRowEnd;
			j = vColEnd;

			while(j >= vColStart) {
				System.out.print(arr[i][j--] + " ");
				n++;
			}

			vRowEnd--;
			j = vColStart;
			i = vRowEnd;

			while(i >= vRowStart) {
				System.out.print(arr[i--][j] + " ");
				n++;
			}
			vColStart++;
		}
		System.out.println();
	}

	public static void main(String args[]) {
		int arr[][] = { {1,2,3,4}, {12,13,14,5}, {11,16,15,6}, {10,9,8,7}};
		//int arr[][] = { {1,2,3}, {8,9,4}, {7,6,5} };
		spiralTraverse(arr);
	}
}
