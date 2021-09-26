import java.util.Map;
import java.util.HashMap;
//LSWD = Longest Substring Without Duplication

class LSWD {
	public static String solve(String str) {
		if(str.length() <= 1 ) return str;

		int longest[] = {0,0};
		
		Map<Character, Integer> lastSeenAt = new HashMap<>();	

		int start = 0;
		int end = 0;
		
		while(end < str.length()) {
			char alphabet = str.charAt(end);
			
			if(lastSeenAt.containsKey(alphabet)) {
				start = Math.max(start, lastSeenAt.get(alphabet) + 1);
			}
			
			if(end-start >= longest[1]-longest[0]) {
				longest[0] = start;
				longest[1] = end;
			}

			lastSeenAt.put(alphabet, end);
			end++;
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
