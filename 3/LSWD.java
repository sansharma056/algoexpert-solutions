import java.util.Map;
import java.util.HashMap;
//LSWD = Longest Substring Without Duplication

class LSWD {
	public static String solve(String str) {
		if(str.length() <= 1 ) return str;

		int longest[] = {0,0};
		int maxLength  = Integer.MIN_VALUE;
		
		Map<Character, Integer> lastSeenAt = new HashMap<>();	

		int start = 0;
		int end = 0;

		for(int i=0; i<str.length(); i++) {
			char alphabet = str.charAt(i);
			
				if(lastSeenAt.containsKey(alphabet)) {
					int length = end-start+1;

					if(length >= maxLength) {
						maxLength = length;
						longest[0] = start;
						longest[1] = end;
					}		
					
					if(lastSeenAt.get(alphabet) >= start) {
						start = lastSeenAt.get(alphabet) + 1;
					}

			}

			lastSeenAt.put(alphabet, i);
			end = i;
		}
		
		int length = end-start+1;

		if(length >= maxLength) {
			maxLength = length;
			longest[0] = start;
			longest[1] = end;
		}		

		return str.substring(longest[0], longest[1]+1);
	} 
	
	public static void main(String args[]) {
		String strs[] = {"abcabcbb", "bbbbb", "pwwkew", "", "clementisacap", "abc"};
		for(String str : strs) {
			System.out.println(solve(str));
		}
	}
}
