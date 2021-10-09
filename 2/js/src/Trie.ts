class TrieNode {
	children: Map<String, TrieNode | null>

	constructor() {
		this.children = new Map();
	}
}

class Trie {
	root: TrieNode
	endSymbol: string

	constructor() {
		this.endSymbol = "*";
		this.root = new TrieNode();
	}

	insert(word: string) {
		let cur = this.root;

		for(const char of word) {
			if(!cur.children.has(char)) {
				cur.children.set(char, new TrieNode());
			}

			cur = cur.children.get(char)!;
		}

		cur.children.set(this.endSymbol, null);
	}

	contains(word: string): boolean {
		let cur = this.root;

		for(const char of word) {
			if(!cur.children.has(char)) {
				return false;
			}
			cur = cur.children.get(char)!;
		}

		return cur.children.has(this.endSymbol);
	}
}
