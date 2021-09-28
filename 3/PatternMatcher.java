import java.util.List;

class PatternMatcher {
	public static boolean isValidXY(int countsAndFirstY[], int x, String str) {
		int n = str.length();
		int y = n - countsAndFirstY[0] * x;
		
		if(y < 0) {
			return false;	
		}

		return y % countsAndFirstY[1] == 0 ? true : false;
	}

	public static String convert(String pattern) {
		StringBuilder newPattern = new StringBuilder();
		for(int i=0; i<pattern.length(); i++) {
			char cur = pattern.charAt(i);
			if(cur == 'y') {
				newPattern.append('x');
			} else {
				newPattern.append('y');
			}
		}

		return newPattern.toString();
	}
	
	public static int[] getCountsAndFirstY(String pattern) {
		int countsAndFirstY[] = new int[3];

		for(int i=0; i<pattern.length(); i++) {
			char p = pattern.charAt(i);
			if(p == 'x') {
				countsAndFirstY[0]++;
			} else {
					if(countsAndFirstY[1] == 0) {
						countsAndFirstY[2] = i;
					}
					countsAndFirstY[1]++;
			}
		}

		return countsAndFirstY;
	}
	
	public static String generateString(String x, String y, String pattern) {
		StringBuilder generatedString = new StringBuilder();	
		
		for(char c : pattern.toCharArray()) {
			if(c == 'x') {
				generatedString.append(x);
			} else {
					generatedString.append(y);
			}
		}
		
		return generatedString.toString();
	}

	public static List<String> solve(String pattern, String str) {
		int n = str.length();
		boolean didSwitch = false;	

		if(pattern.charAt(0) == 'y') {
			pattern = convert(pattern);
			didSwitch = true;
		}

		int countsAndFirstY[] = getCountsAndFirstY(pattern);

		for(int i=1; i<=str.length(); i++) {

			int y = n - countsAndFirstY[0] * i;
		
			if(y <= 0) {
				break;
			} else if(y % countsAndFirstY[1] != 0) {
					continue;
			}
			
			y /= countsAndFirstY[1];

			String possibleX = str.substring(0, i);
			String possibleY = str.substring(countsAndFirstY[2] * i, countsAndFirstY[2] * i + y);
			if(generateString(possibleX, possibleY, pattern).equals(str)) {
				return didSwitch ? List.of(possibleY, possibleX) : List.of(possibleX, possibleY);
			}
		}	

		return List.of();
	}

	public static void main(String args[]) {
		String pattern = "xxyxxy";
		String str = "gogopowerrangergogopowerranger";
		
		System.out.println(solve(pattern, str));
	}
}
