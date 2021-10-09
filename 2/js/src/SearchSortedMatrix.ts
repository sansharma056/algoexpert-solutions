function search(matrix: number[][], x: number): [number, number] {
	let i=0;
	let j=matrix[0].length-1;

	while(i<matrix.length && j>=0) {
		if(x < matrix[i][j]) {
			j--;
		} else if(x > matrix[i][j]) {
			i++;
		} else {
			return [i,j];
		}
	}

	return [-1, -1];
}

(function main() {
	const matrix =
	[
		[1,4,7,12,15,1000],
		[2,5,19,31,32,1001],
		[3,8,24,33,35,1002],
		[40,41,42,44,45,1003],
		[99,100,103,106,128,1004]
	];

	const x = 44;

	console.log(search(matrix, x));
})();
