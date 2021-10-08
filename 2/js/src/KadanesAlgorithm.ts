function solve(list: number[]): number {
	const n = list.length;
	let max = list[0];

	for(let i=1; i<n; i++) {
		list[i] = Math.max(list[i], list[i] + list[i-1]);
		max = Math.max(list[i], max);
	}

	return max;
}

(function main() {
	const list = [3,5,-9,1,3,-2,3,4,7,2,-9,6,3,1,-5,4];

	console.log(solve(list));
})();
