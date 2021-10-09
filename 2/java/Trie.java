class Trie {
	Node root = new Node();	
	
	class Node {
		boolean isEnd;
		Node child[];

		Node() {
			isEnd = false;
			child = new Node[26];
		}
	}	
	
	public void insert(String word) {
		Node cur = root;

		for(int i=0; i<word.length(); i++) {
			char letter = word.charAt(i);
			int pos = letter - 'a';
			
			if(cur.child[pos] == null) {
				cur.child[pos] = new Node();

				if(i == word.length()-1) {
					cur.child[pos].isEnd = true;
				}
			}

			cur = cur.child[pos];
		}
	}
	
	public void print() {
		StringBuffer string = new StringBuffer();
		print(root, string);
	} 

	void print(Node node, StringBuffer string) {
		if(node.isEnd) {
			System.out.println(string);
			return;
		}
		
		for(char letter='a'; letter<='z'; letter++) {
			int pos = letter - 'a';
			if(node.child[pos] != null) {
				StringBuffer newString = new StringBuffer(string);
				newString.append(letter);
				print(node.child[pos], newString);
			}
		}
	}
	

	public static void main(String args[]) {
		var trie = new Trie();
		trie.insert("bandana");
		trie.insert("banana");
		trie.insert("bad");
		trie.print();
	}
}
