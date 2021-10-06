class PalindromeCheck {
	
	public static boolean isPalindrome(String str) {
		boolean flag = true;
		int n = str.length();

		for(int i=0, j=n-1; i<n/2; i++,j--) {
			if(str.charAt(i) != str.charAt(j)) {
				return false;
			}
		}

		return flag;
	}

	public static void main(String args[]) {
		String str = "abcdcba";
		
		System.out.println(isPalindrome(str));

	}
}
