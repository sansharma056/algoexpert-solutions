import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class MultiStringSearch {
// Time Complexity: O(b^2 + ns) Space Complexity: O(b^2)
// 	public static boolean[] solve(String bigString, String strings[]) {
// 		boolean res[] = new boolean[strings.length];
// 		Trie trie = generateTrie(bigString);
		
// 		for(int i=0; i<strings.length; i++) {
// 			res[i] = trie.search(strings[i]);
// 		}

// 		return res;
// 	}
	

// 	public static Trie generateTrie(String bigString) {
// 		Trie trie = new Trie();	
// 		int n = bigString.length();

// 		for(int i=n-1; i>=0; i--) {
// 			trie.insert(bigString.substring(i, n));	
// 		}

// 		return trie;
// 	}

	public static void main(String args[]) {
		String bigString = "this is a big string";
		String strings[] = {"this", "yo", "is", "a", "bigger", "string", "kappa"};

		System.out.println(Arrays.toString(solve(bigString, strings)));
	}

// Time Complexity: O(ns + bs) Space Complexity: O(ns)
	public static boolean[] solve(String bigString, String strings[]) {
		boolean[] res = new boolean[strings.length];
		Trie trie = generate(strings);
		Map<String, Boolean> containedStrings = new HashMap<>();	
		
		for(int i=0; i<bigString.length(); i++) {
			search(bigString, i, trie, containedStrings);
		}
		
		for(int i=0; i<strings.length; i++) {
			res[i] = containedStrings.getOrDefault(strings[i], false);
		}

		return res;
	}
	
	public static void search(String bigString, int startIdx, Trie trie, Map<String, Boolean> containedStrings) {
		TrieNode cur = trie.root;
		for(int i=startIdx; i<bigString.length(); i++) {
			char c = bigString.charAt(i);
			if(!cur.children.containsKey(c)) {
				return;
			}
			cur = cur.children.get(c);
			if(cur.children.containsKey(trie.END_CHAR)) {
				containedStrings.put(cur.word, true);
				return;
			}
		}
	}

	public static Trie generate(String[] strings) {
		Trie trie = new Trie();

		for(String string : strings) {
			trie.insert(string);
		}

		return trie;
	}
}

class Trie {
	TrieNode root = new TrieNode();
	char END_CHAR = '*';
	
	public boolean search(String word) {
		TrieNode cur = root;	
	
		for(char c : word.toCharArray()) {
			if(cur.children.containsKey(c)) {
				cur = cur.children.get(c);
			}	else {
					return false;
			}
		}
		
		if(cur.children.containsKey(END_CHAR) && cur.word.equals(word)) {
			return true;
		} 

		return false;
	}

	public void insert(String word) {
		TrieNode cur = root;

		for(char a : word.toCharArray()) {
			if(!cur.children.containsKey(a)) {
				cur.children.put(a, new TrieNode());
			}
			cur = cur.children.get(a);
		}
		
		cur.children.put(END_CHAR, null);
		cur.word = word;
	}
}

class TrieNode {
	Map<Character, TrieNode> children;
	String word;

	TrieNode()  {
		children = new HashMap<>();
		word = "";
	}
}
