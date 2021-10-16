import { TrieNode, Trie } from "./Trie";

function boggleBoard(board: string[][], words: string[]) {
	const r = board.length;
	const c = board[0].length;

	const visited: boolean[][] = board.map((row) => row.map(() => false));
	const res: Set<string> = new Set();

	const trie: Trie = new Trie();
	for (const word of words) {
		trie.insert(word);
	}

	for (let i = 0; i < r; i++) {
		for (let j = 0; j < c; j++) {
			visit(i, j, trie.root, board, visited, res);
		}
	}

	return res;
}

function visit(
	i: number,
	j: number,
	cur: TrieNode,
	board: string[][],
	visited: boolean[][],
	res: Set<string>
) {
	if (visited[i][j]) {
		return;
	}

	const char = board[i][j];

	if (!cur.children.has(char)) {
		return;
	}

	cur = cur.children.get(char)!;
	visited[i][j] = true;

	if (cur.children.has(Trie.END_SYMBOL)) {
		res.add(cur.word);
	}

	const neighbours = getUnvisitedNeighbours(i, j, board, visited);
	for (const neighbour of neighbours) {
		visit(neighbour[0], neighbour[1], cur, board, visited, res);
	}

	visited[i][j] = false;
}

function getUnvisitedNeighbours(
	i: number,
	j: number,
	board: string[][],
	visited: boolean[][]
): [number, number][] {
	const X = [0, 0, 1, -1, 1, -1, -1, 1];
	const Y = [1, -1, 0, 0, 1, -1, 1, -1];

	const unvisitedNeighbours: [number, number][] = [];
	for (let k = 0; k < 8; k++) {
		const x = X[k] + i;
		const y = Y[k] + j;

		if (
			x >= 0 &&
			x < board.length &&
			y >= 0 &&
			y < board[0].length &&
			!visited[x][y]
		) {
			unvisitedNeighbours.push([x, y]);
		}
	}

	return unvisitedNeighbours;
}

(function main() {
	const board = [
		["t", "h", "i", "s", "i", "s", "a"],
		["s", "i", "m", "p", "l", "e", "x"],
		["b", "x", "x", "x", "x", "e", "b"],
		["x", "o", "g", "g", "l", "x", "o"],
		["x", "x", "x", "D", "T", "r", "a"],
		["R", "E", "P", "E", "A", "d", "x"],
		["x", "x", "x", "x", "x", "x", "x"],
		["N", "O", "T", "R", "E", "-", "P"],
		["x", "x", "D", "E", "T", "A", "E"],
	];

	const words = [
		"this",
		"is",
		"not",
		"a",
		"simple",
		"boggle",
		"board",
		"test",
		"REPEATED",
		"NOTRE-PEATED",
	];

	console.log(boggleBoard(board, words));
})();
