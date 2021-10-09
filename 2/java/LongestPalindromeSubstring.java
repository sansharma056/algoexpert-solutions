import java.util.*;

class LongestPalindromSubstring {
	/*
	public static int findLongestPalindromeSubstring(String str) {
		int longest = 0;	
		Map<Character, Boolean> checked = new HashMap<>();

		for(int i=0; i<str.length()-1; i++) {
			if(checked.get(str.charAt(i)) == null) {
				for(int j=i+1; j<str.length(); j++) {
					if(str.charAt(i) == str.charAt(j)) {
						longest = Math.max(longest, getPalindromeLength(str, i, j));
						checked.put(str.charAt(i), true);
						break;
					}
				}
			}
		}

		return longest;
	}
	
	public static int getPalindromeLength(String str, int i, int j) {
		if(isPalidrome(str, i, j)) {
			return j-i+1;
		} else {
			return 0;
		}
	}

	public static boolean isPalidrome(String str, int i, int j) {
		int mid = (j+i)/2;
	
		for(int k=i, l=j; k<mid; k++,l--) {
			if(str.charAt(k) != str.charAt(l)) {
				return false;
			}
		}

		return true;
	}
	*/
	
	public static int[] max(int x1[], int x2[]) {
		if(x2[1] - x2[0] > x1[1] - x1[0])	 {
			return x2;
		}
		
		return x1;
	}

	public static String findLongestPalindromeSubstring(String str) {
		int longestPalindrome[] = new int[]{0,1};	

		for(int i=0; i<str.length(); i++)	{
			int odd[] = getLongestPalindrome(str, i-1, i+1);
			int even[] = getLongestPalindrome(str, i-1, i);
			int longest[] = max(odd, even);
			longestPalindrome = max(longest, longestPalindrome);
		}
			
		return str.substring(longestPalindrome[0], longestPalindrome[1]);
	}
	
	public static int[] getLongestPalindrome(String str, int left, int right) {
		while(left >= 0 && right < str.length()) {
			if(str.charAt(left) != str.charAt(right)) {
				break;
			} 
			left--;
			right++;
		}

		return new int[]{left+1, right};
	}

	public static void main(String args[]) {
		String str = "abaxyzzyxf";
		//String str = "forgeeksskeegfor";
		System.out.println(findLongestPalindromeSubstring(str));
	}
}
