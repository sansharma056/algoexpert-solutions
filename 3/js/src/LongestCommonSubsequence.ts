function longestCommonSubsequence(str1: string, str2: string): string {
	const r = str1.length;
	const c = str2.length;

	const matrix: string[][] = [];
	for(let i=0; i<=r; i++) {
		const row: string[] = [];
		for(let j=0; j<=c; j++) {
			row.push("");
		}
		matrix.push(row);
	}

	for(let i=1; i<=r; i++) {
		for(let j=1; j<=c; j++) {
			if(str1.charAt(i-1) == str2.charAt(j-1)) {
				matrix[i][j] = matrix[i-1][j-1] + str1.charAt(i-1);
			} else {
				matrix[i][j] = matrix[i][j-1].length > matrix[i-1][j].length ? matrix[i][j-1] : matrix[i-1][j];
			}
		}
	}

	return matrix[r][c];
}

function longestCommonSubsequenceAlt(str1: string, str2: string): string {
	const r = str1.length;
	const c = str2.length;

	const matrix: [number, number, number, number][][] = [];
	for(let i=0; i<=r; i++) {
		const row: [number, number, number, number][] = [];
		for(let j=0; j<=c; j++) {
			row.push([0, 0, 0, 0]);
		}
		matrix.push(row);
	}

	for(let i=1; i<=r; i++)	{
		for(let j=1; j<=c; j++) {
			if(str1.charAt(i-1) == str2.charAt(j-1)) {
				matrix[i][j] = [str1.charCodeAt(i-1), matrix[i-1][j-1][1] + 1, i-1, j-1];
			} else if(matrix[i-1][j][1] > matrix[i][j-1][1]) {
				matrix[i][j] = [-1, matrix[i-1][j][1], i-1, j];
			} else {
				matrix[i][j] = [-1, matrix[i][j-1][1], i, j-1];
			}
		}
	}

	return buildSequence(matrix);
}

function buildSequence(matrix: [number, number, number, number][][]): string {
	let res: string[] = [];
	let i=matrix.length-1, j=matrix[0].length-1;

	while(i!= 0 && j!=0) {
		const cur = matrix[i][j];

		if(cur[0] != -1) {
			res.unshift(String.fromCharCode(cur[0]));
		}

		i = cur[2];
		j = cur[3];
	}

	return res.join("");
}

(function main() {
	const str1 = "zxvvyzw";
	const str2 = "xkykzpw";

	console.log(longestCommonSubsequence(str1, str2));
	console.log(longestCommonSubsequenceAlt(str1, str2));
})();
