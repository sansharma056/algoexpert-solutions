function longestSubstringWithoutDuplication(str: string): string {
	const lastSeenAt: Map<string, number> = new Map();
	const longest: [number, number] = [0,0];

	let start = 0;
	let end = 0;

	while(end < str.length) {
		const char = str.charAt(end);

		if(lastSeenAt.has(char)) {
			start = Math.max(start, lastSeenAt.get(char)! +1);
		}

		if(end - start >= longest[1] - longest[0]) {
			[longest[0], longest[1]] = [start, end];
		}

		lastSeenAt.set(char, end);
		end++;
	}

	return str.substring(longest[0], longest[1]+1);
}

(function main() {
	const str = "clementisacap";
	console.log(longestSubstringWithoutDuplication(str));
})();
