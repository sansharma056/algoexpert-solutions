function numbersInPi(num: string, favNums: string[]) {
	const set: Set<string> = new Set(favNums);
	const memo: Map<number, number> = new Map();

	numbersInPiHelper(0, num, set, memo);

	const minSpaces = memo.get(0);

	return minSpaces == Number.POSITIVE_INFINITY ? -1 : minSpaces;
}

function numbersInPiHelper(
	start: number,
	num: string,
	set: Set<string>,
	memo: Map<number, number>
): number {
	const n = num.length;

	if (start == n) {
		return -1;
	}

	if (memo.has(start)) {
		return memo.get(start)!;
	}

	let minSpaces = Number.POSITIVE_INFINITY;

	for (let i = start + 1; i <= n; i++) {
		if (set.has(num.substring(start, i))) {
			const minSpaceSuffix = numbersInPiHelper(i, num, set, memo);
			minSpaces = Math.min(minSpaceSuffix + 1, minSpaces);
		}
	}

	memo.set(start, minSpaces);
	return minSpaces;
}

(function main() {
	const num = "3141592";
	const favNums = ["3141", "5", "31", "2", "4159", "9", "42", "592"];

	console.log(numbersInPi(num, favNums));
})();
