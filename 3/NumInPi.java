import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

class NumInPi {
	
	public static int solve(String pi, String favNums[]) {
		Set<String> numbers = new HashSet<>();

		for(String num : favNums) {
			numbers.add(num);
		}

		Map<Integer, Integer> memo = new HashMap<>();
		int minSpaces = solve(pi, memo, numbers, 0);

		return minSpaces == Integer.MAX_VALUE ? -1 : minSpaces;
	}

	public static int solve(String pi, Map<Integer, Integer> memo, Set<String> numbers, int idx) {
		if(idx == pi.length()) {
			return -1;
		}

		if(memo.containsKey(idx)) {
			return memo.get(idx);
		}
		
		int minSpaces = Integer.MAX_VALUE;
		for(int i=idx; i<pi.length(); i++) {
			String prefix = pi.substring(idx, i+1);

			if(numbers.contains(prefix)) {
				int minSpaceSuffix = solve(pi, memo, numbers, i+1);
				
				if(minSpaceSuffix == Integer.MAX_VALUE) {
					minSpaces = minSpaceSuffix;
				} else {
						minSpaces = Math.min(minSpaceSuffix+1, minSpaces);
				}
			}
		}
		
		memo.put(idx, minSpaces);

		return memo.get(idx);
	}

	public static void main(String args[]) {
		String pi = "3141592";
		String favNums[] = {"3141","5","31","2","4159","9","42"};

		System.out.println(solve(pi, favNums));
	}
}
