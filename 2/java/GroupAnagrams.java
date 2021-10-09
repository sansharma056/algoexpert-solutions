import java.util.*;
import java.util.stream.*;

class GroupAnagrams {
	/*
	public static List<String> getGroupAnagrams(List<Object> groups) {
		List<String> anagrams = new ArrayList<String>();

		for(int i=0; i<groups.size(); i++) {
			String group[] = (String [])groups.get(i);
			boolean anagramFound = false;
			String key = group[0];

			Set<Character> keySet = new HashSet<>();	
			key.chars().forEach(x -> keySet.add(Character.valueOf( (char)x )));

			for(int j=1; j<group.length; j++) {
				if(key.length() == group[j].length()) {
					Set<Character> possibleSet = new HashSet<>();
					group[j].chars().forEach(x -> possibleSet.add(Character.valueOf( (char)x )));
					if(keySet.equals(possibleSet)) {
						anagrams.add(group[j]);
						anagramFound = true;
					}
				}
			}

			if(anagramFound) {
				anagrams.add(key);
			}
		}

		return anagrams;
	}	
	*/
	
	public class StringComparator implements Comparator<String> {
		public int compare(String obj1, String obj2) {
			if(obj1 == obj2) {
				return 0;
			}
			
			if(obj1 == null) {
				return -1;
			}
		
			if(obj2 == null) {
				return 1;
			}

			return obj1.compareTo(obj2);
		}
	}

	public static List<List<String>> groupAnagrams(String[] anagrams) {
		List<List<String>>  groups = new ArrayList<>();
		Map<String, List<String>> anagramMap = new HashMap<>();

		for(String anagram : anagrams) {
				char anagramCharArray[] = anagram.toCharArray();
				Arrays.sort(anagramCharArray);
				String sortedAnagram = new String(anagramCharArray);

				if(anagramMap.containsKey(sortedAnagram)) {
					anagramMap.get(sortedAnagram).add(anagram);
				} else {
						anagramMap.put(sortedAnagram, new ArrayList<String>(List.of(anagram)));
				}
		}
		
		groups.addAll(anagramMap.values());
		return groups;
	}

	public static void main(String args[]) {
		//List<Object> groups = List.of(new String[]{"yo","oy"}, new String[]{"flop", "olfp"} , new String[]{"act", "tac", "cat"});
		String anagrams[] = {"yo", "act", "flop", "tac", "cat", "oy", "olfp"};	

		System.out.println(groupAnagrams(anagrams));
	}
}
