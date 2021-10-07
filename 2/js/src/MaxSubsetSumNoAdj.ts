function solve(list: number[]): number {
	const n = list.length;

	let sum: number[] = [];
	sum[0] = list[0];
	sum[1] = Math.max(list[0], list[1]);

	for(let i=2; i<n; i++) {
		list[i] = Math.max(list[i] + list[i-2], list[i-1]);
	}

	console.log(list);
	return list[n-1];
}

(function main() {
	const list = [7,10,12,7,9,14];

	console.log(solve(list));
})();
