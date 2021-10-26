import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class BoggleBoard {
	public static Set<String> boggleBoard(String words[], char board[][]){
		Trie trie = new Trie();
		for(String word: words) {
			trie.add(word);
		}
		
		int r = board.length;
		int c = board[0].length;
		boolean visited[][] = new boolean[r][c];
	
		Set<String> finalWords = new HashSet<>();
		
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				explore(i, j, board, visited, trie.root, finalWords);
			}
		}

		return finalWords;
	}

	public static void explore(
			int i,
			int j,
			char board[][],
			boolean visited[][],
			TrieNode root,
			Set<String> finalWords
			) {
		if(visited[i][j]) {
			return;
		}
	
		char letter = board[i][j];

		if(!root.children.containsKey(letter)) {
			return;
		}
		
		visited[i][j] = true;
		root = root.children.get(letter);
		
		if(root.children.containsKey('*')) {
			finalWords.add(root.word);
		}	
		
		List<int[]> neighbours = getNeighbours(i, j, board);
		for(int[] neighbour : neighbours) {
			explore(neighbour[0], neighbour[1], board, visited, root, finalWords);
		}
		visited[i][j] = false;
	}
	
	public static List<int[]> getNeighbours(int i, int j, char board[][]) {
		List<int[]> neighbours =  new ArrayList<>();
		
		int xDir[] = {0, 1, 0, -1, 1, -1, 1, -1};
		int yDir[] = {1, 0, -1, 0, 1, -1, -1, 1};
			
		for(int k=0; k<xDir.length; k++) {
			int newI = i + xDir[k];
			int newJ = j + yDir[k]; 
			
			if( (newI >= 0 && newI < board.length) && (newJ >=0 && newJ < board[0].length)  ) {
				neighbours.add(new int[]{newI, newJ});
			}
		}

		return neighbours;
	}

	public static void main(String args[]) {
		String words[] = {"this", "is", "not", "a", "simple", "boggle", "board", "test", "REPEATED", "NOTRE-PEATED"};
		char board[][] = {
			{'t', 'h', 'i', 's', 'i', 's', 'a'},
			{'s', 'i', 'm', 'p', 'l', 'e', 'x'},
			{'b', 'x', 'x', 'x', 'x', 'e', 'b'},
			{'x', 'o', 'g', 'g', 'l', 'x', 'o'},
			{'x', 'x', 'x', 'D', 'T', 'r', 'a'},
			{'R', 'E', 'P', 'E', 'A', 'd', 'x'},
			{'x', 'x', 'x', 'x', 'x', 'x', 'x'},
			{'N', 'O', 'T', 'R', 'E', '-', 'P'},
			{'x', 'x', 'D', 'E', 'T', 'A', 'E'}
		};
		
		System.out.println(boggleBoard(words, board));
	}
}

class TrieNode {
	Map<Character, TrieNode> children;
	String word;

	TrieNode() {
		this.children = new HashMap<>();
		this.word = "";
	}
}

class Trie {
	TrieNode root;
	
	Trie() {
		this.root = new TrieNode();
	}
	
	void add(String word) {
		TrieNode node = root;

		for(char letter : word.toCharArray()) {
			if(!node.children.containsKey(letter)) {
				node.children.put(letter, new TrieNode());
			}
			
			node = node.children.get(letter);
		}	
		
		node.children.put('*', null);
		node.word = word;
	}
}
