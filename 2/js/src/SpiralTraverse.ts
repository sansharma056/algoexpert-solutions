function spiralTraverse(matrix: (number[])[]): number[] {
	let res: number[] = [];

	let rowRange: [number, number] = [0,matrix.length-1];
	let colRange: [number, number] = [0,matrix[0].length-1];

	while(rowRange[0] <= rowRange[1] && colRange[0] <= colRange[1]) {
		for(let k=colRange[0]; k<=colRange[1]; k++) {
			res.push(matrix[rowRange[0]][k]);
		}

		rowRange[0]++;

		for(let k=rowRange[0]; k<=rowRange[1]; k++) {
			res.push(matrix[k][colRange[1]]);
		}

		colRange[1]--;

		for(let k=colRange[1]; k>=colRange[0]; k--) {
			res.push(matrix[rowRange[1]][k]);
		}

		rowRange[1]--;

		for(let k=rowRange[1]; k>=rowRange[0]; k--) {
			res.push(matrix[k][colRange[0]])
		}

		colRange[0]++;
	}

	return res;
}

(function main() {
	const matrix = [ [1,2,3,4], [12,13,14,5], [11,16,15,6], [10,9,8,7]];
	console.log(spiralTraverse(matrix));
})();
