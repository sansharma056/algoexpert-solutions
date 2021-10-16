class TrieNode {
	word: string;
	children: Map<string, TrieNode | null>;

	constructor() {
		this.word = "";
		this.children = new Map();
	}
}

class Trie {
	static readonly END_SYMBOL = "*";
	root: TrieNode;

	constructor() {
		this.root = new TrieNode();
	}

	insert(word: string) {
		let cur = this.root;

		for (const char of word.split("")) {
			if (!cur.children.has(char)) {
				cur.children.set(char, new TrieNode());
			}

			cur = cur.children.get(char)!;
		}

		cur.word = word;
		cur.children.set(Trie.END_SYMBOL, null);
	}

	contains(word: string): boolean {
		let cur = this.root;

		for (const char of word.split("")) {
			if (!cur.children.has(char)) {
				return false;
			}
			cur = cur.children.get(char)!;
		}

		return cur.word == word;
	}
}

export { TrieNode, Trie };
