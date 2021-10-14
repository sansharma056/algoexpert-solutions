function getItems(memo: number[][], items: [number,number][]): [number, number][] {
	const res: [number, number][] = [];

	let i=memo.length-1, j=memo[0].length-1;
	while(i > 0 && j > 0) {
		if(memo[i][j] != memo[i-1][j]) {
			res.push(items[i-1]);
			j -= items[i-1][1];
		}

		i--;
	}

	return res;
}

function knapsackProblem(items: [number, number][], size: number): [number, number][] {
	items.sort( (a,b) => a[1] - b[1] );
	const memo: number[][] = [];

	for(let i=0; i<=items.length; i++) {
		const row: number[] = [];
		for(let j=0; j<=size; j++) {
			row.push(0);
		}
		memo.push(row);
	}

	for(let i=1; i<=items.length; i++) {
		const item = items[i-1];

		for(let j=0; j<item[1]; j++) {
			memo[i][j] = memo[i-1][j];
		}

		for(let j=item[1]; j<=size; j++) {
			memo[i][j] = item[0] + memo[i-1][j - item[1]];
		}
	}

	return getItems(memo, items);
}

(function main() {
	const items: [number, number][] = [[1,2], [4,3], [5,6], [6,7]];
	const size: number = 10;

	console.log(knapsackProblem(items, size));
})();
