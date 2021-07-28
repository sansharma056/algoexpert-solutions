class LevinshteinDistance {
	public static int getLevinshteinDistance(String str1, String str2) {
		int n = str1.length();
		int m = str2.length();
		int matrix[][] = new int[n+1][m+1];	
		
		for(int i=0; i<=m; i++){
			matrix[0][i] = i;
		}

		for(int i=1; i<=n; i++){
			matrix[i][0] = i;
		}
	
		for(int r=1; r<=n; r++) {
			for(int c=1; c<=m; c++) {
				if(str1.charAt(r-1) == str2.charAt(c-1)) {
					matrix[r][c] = matrix[r-1][c-1];
				} else {
					matrix[r][c] = Math.min(matrix[r-1][c-1], Math.min(matrix[r-1][c], matrix[r][c-1])) + 1;
				}
			}
		}

		return matrix[n][m];
	}

	public static void main(String args[]) {
		String str1 = "abc";
		String str2 = "yabd";

		System.out.println(getLevinshteinDistance(str1, str2));
	}
}
