function groupAnagrams(strings: string[]): string[][] {
	const map: Map<string, string[]> = new Map();

	for(const str of strings) {
		const sortedStr = sortCharacters(str);

		if(map.get(sortedStr) == undefined) {
			map.set(sortedStr, []);
		}

		map.get(sortedStr)!.push(str);
	}

	const groups: string[][] = Array.from(map.values());

	return groups;
}

function sortCharacters(str: string): string {
	const characters = str.split("");
	characters.sort();
	return characters.join("");
}

(function main() {
	const strings = ["yo", "act", "flop", "tac", "cat", "oy", "olfp"];
	console.log(groupAnagrams(strings));
})();
