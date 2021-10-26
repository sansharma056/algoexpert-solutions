import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class UnderscorifySubtring {
	public static List<Integer[]> getLocations(String string, String substring) {
		List<Integer[]> locations = new ArrayList<>();

		int i = 0;
		while(i < string.length()) {
			int begIdx = string.indexOf(substring, i);

			if(begIdx == -1) {
				break;
			}

			locations.add(new Integer[]{begIdx, begIdx+substring.length()});
			i = begIdx + 1;
		}

		return locations;
	}

	public static List<Integer[]> collapse(List<Integer[]> locations) {
		List<Integer[]> newLocations = new ArrayList<>();

		Integer[] prev = locations.get(0);
		newLocations.add(prev);

		for(int i=1; i<locations.size(); i++) {
			Integer[] cur = locations.get(i);

			if(cur[0] <= prev[1]) {
				prev[1] = cur[1];
			} else {
					newLocations.add(cur);
					prev = cur;
			}
		}

		return newLocations;
	}


	public static String solve(String string, String substring) {
		List<Integer[]> locations = collapse( getLocations(string, substring) );
		StringBuilder res = new StringBuilder(string);

		for(int i=locations.size()-1; i>=0; i--) {
			Integer location[] = locations.get(i);

			res.insert(location[1], "_");
			res.insert(location[0], "_");
		}

		return res.toString();
	}

	public static void main(String args[]) {
		String string = "testthis is a testtest to see if testestest it works";
		String substring = "test";

		System.out.println(solve(string, substring));
	}
}
