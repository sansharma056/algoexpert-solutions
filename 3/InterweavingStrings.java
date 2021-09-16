class InterweavingStrings {
	public static boolean isPossible(int i, int j, String str1, String str2, String str3, Boolean memo[][]) {
		if(memo[i][j] != null) {
			return memo[i][j];
		}

		int k = i + j; 

		if(k == str3.length()) {
			return true;

		}

		char kChar= str3.charAt(k);

		if(i < str1.length() && kChar == str1.charAt(i)) {
			memo[i][j] = isPossible(i+1, j, str1, str2, str3, memo);
		
			if(memo[i][j]) {
				return true;
			}
		}

		if(j < str2.length() && kChar == str2.charAt(j)) {
			memo[i][j] = isPossible(i, j+1, str1, str2, str3, memo);
			return memo[i][j];
		}
		
		memo[i][j] = false;
		return false;
	}

	public static void main(String args[]) {
		String str1 = "aaa";
		String str2 = "aaaf";
		String str3 = "aaafaaa";
		
		Boolean memo[][] = new Boolean[str1.length()+1][str2.length()+1];

		System.out.println(isPossible(0, 0, str1, str2, str3, memo));
	}
}
