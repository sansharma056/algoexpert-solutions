class LongestCommonSubseq {
	
	/*
	public static String getLongestCommonSubseq(String str1, String str2) {
		int r = str1.length();
		int c = str2.length();
		
		StringBuffer lcs[][] = new StringBuffer[r+1][c+1];
		
		for(int i=0; i<=r; i++)	 {
			for(int j=0; j<=c; j++) {
				lcs[i][j] = new StringBuffer();
			}
		}

		for(int i=1; i<=r; i++)	 {
			for(int j=1; j<=c; j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					lcs[i][j] = new StringBuffer(lcs[i-1][j-1]);
					lcs[i][j].append(str1.charAt(i-1));
				} else {
					lcs[i][j] = lcs[i-1][j].length() > lcs[i][j-1].length() ? new StringBuffer(lcs[i-1][j]) : new StringBuffer(lcs[i][j-1]);
				}
			}
		}
		
		for(int i=0; i<=r; i++) {
			for(int j=0; j<=c; j++) {
				System.out.print(lcs[i][j] + "\t");
			}
			System.out.println();
		}
			
		return new String(lcs[r][c]);
	}
	*/

	public static String getLongestCommonSubseq(String str1, String str2) {
		int r = str1.length();
		int c = str2.length();
		
		int[][][] lcs = new int[r+1][c+1][];

		for(int i=0; i<=r; i++)	 {
			for(int j=0; j<=c; j++) {
				lcs[i][j] = new int[]{0,0,0,0};
			}
		}
		
		for(int i=1; i<=r; i++) {
			for(int j=1; j<=c; j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					lcs[i][j] = new int[]{str1.charAt(i-1), lcs[i-1][j-1][1]+1, i-1, j-1};
				} else {
						if(lcs[i-1][j][1] > lcs[i][j-1][1]) {
							lcs[i][j] = new int[]{-1, lcs[i-1][j][1], i-1, j};
						} else {
								lcs[i][j] = new int[]{-1, lcs[i][j-1][1], i, j-1};
						}
				}
			}
		}
		
		return buildSeq(lcs);
	}
	
	public static String buildSeq(int lcs[][][]) {
		int i = lcs.length-1;
		int j = lcs[0].length-1;
		
		StringBuffer res = new StringBuffer();
		while(i != 0 && j != 0) {
			if(lcs[i][j][0] != -1) {
				res.insert(0, (char)lcs[i][j][0]);
			}
			int t = i;
			i = lcs[i][j][2];
			j = lcs[t][j][3];
		}

		return res.toString();
	}

	public static void main(String args[]) {
		
		/*
		String str1 = "zxvvyzw";
		String str2 = "xkykzpw";
		*/	

		/*
		String str1 = "ABCDGH";
		String str2 = "AEDFHR";
		*/
		
		/*
		String str1 = "AGGTAB";
		String str2 = "GXTXAYB";
		*/

		System.out.println(getLongestCommonSubseq(str1, str2));
	}
}
