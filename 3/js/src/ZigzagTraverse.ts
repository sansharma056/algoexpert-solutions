function zigzagTraverse(matrix: number[][]): number[] {
	const r = matrix.length, c = matrix[0].length;
	const res: number[] = [];

	let i=0, j=0;

	while(i<r && j<c) {
		res.push(matrix[i][j]);
		if(i+1 < r) {
			i++;
		} else {
				j++;
		}

		while(i >= 0 && j < c) {
			res.push(matrix[i][j]);
			i--;
			j++;
		}

		i++;
		j--;

		if(j+1 < c) {
			j++;
		} else {
			i++;
		}

		while(i < r-1 && j > 0) {
			res.push(matrix[i][j]);
			i++;
			j--;
		}
	}

	return res;
}

(function main() {
	const matrix: number[][] =
	[
		[1,3,4,10],
		[2,5,9,11],
		[6,8,12,15],
		[7,13,14,16]
	];

	console.log(zigzagTraverse(matrix));
})();
