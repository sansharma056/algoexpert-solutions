function interweavingStrings(
	str1: string,
	str2: string,
	str3: string
): boolean {
	if (str1.length + str2.length != str3.length) {
		return false;
	}

	const memo: boolean[][] = [];
	for (let i = 0; i < str1.length + 1; i++) {
		memo.push([]);
	}

	return interweavingStringsHelper(str1, str2, str3, memo, 0, 0);
}

function interweavingStringsHelper(
	str1: string,
	str2: string,
	str3: string,
	memo: boolean[][],
	i: number,
	j: number
): boolean {
	if (memo[i][j]) {
		return memo[i][j];
	}

	let k = i + j;

	if (k == str3.length) {
		memo[i][j] = true;
		return true;
	}

	if (i < str1.length && str1[i] == str3[k]) {
		memo[i][j] = interweavingStringsHelper(str1, str2, str3, memo, i + 1, j);
		if (memo[i][j]) {
			return true;
		}
	}

	if (j < str2.length && str2[j] == str3[k]) {
		memo[i][j] = interweavingStringsHelper(str1, str2, str3, memo, i, j + 1);
		if (memo[i][j]) {
			return true;
		}
	}

	memo[i][j] = false;
	return false;
}

(function main() {
	const str1 = "aaa";
	const str2 = "aaaf";
	const str3 = "aaafaaa";

	console.log(interweavingStrings(str1, str2, str3));
})();
