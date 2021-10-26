import { TrieNode, Trie } from "./Trie";

function multiStringSearch(
	bigString: string,
	smallStrings: string[]
): boolean[] {
	const trie: Trie = new Trie();
	for (const smallString of smallStrings) {
		trie.insert(smallString);
	}

	const found: Map<string, boolean> = new Map();
	smallStrings.forEach((smallString) => found.set(smallString, false));

	for (let startIdx = 0; startIdx < bigString.length; startIdx++) {
		search(startIdx, bigString, trie, found);
	}

	return Array.from(found.values());
}

function search(
	strIdx: number,
	bigString: string,
	trie: Trie,
	found: Map<string, boolean>
) {
	let cur: TrieNode = trie.root;

	for (let i = strIdx; i < bigString.length; i++) {
		if (!cur.children.has(bigString[i])) {
			return;
		}
		cur = cur.children.get(bigString[i])!;

		if (cur.children.has(Trie.END_SYMBOL)) {
			found.set(cur.word, true);
			return;
		}
	}
}

(function main() {
	const bigString = "this is a big string";
	const smallStrings = ["this", "yo", "is", "a", "bigger", "string", "kappa"];
	console.log(multiStringSearch(bigString, smallStrings));
})();
