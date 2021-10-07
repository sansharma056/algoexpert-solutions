function solve(target: number, denominations: number[]) {
	let ways: number[] = Array(target+1);
	ways[0] = 1;
	ways.fill(0, 1, target+1);

	for(const denom of denominations) {
		for(let i=denom; i <= target; i++) {
			ways[i] += ways[i-denom];
		}
	}

	return ways[target];
}

(function main () {
	const target = 10;
	const denominations = [1,5,10,25];

	console.log(solve(target, denominations));
})();
