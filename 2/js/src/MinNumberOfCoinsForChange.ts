function solve(target: number, denominations: number[]) {
	let coins = Array(target + 1).fill(Number.POSITIVE_INFINITY);
	coins[0] = 0;

	for(const denom of denominations) {
		for(let i=denom; i<=target; i++) {
			coins[i] = Math.min(coins[i], coins[i-denom] + 1);
		}
	}

	return coins[target];
}

(function main() {
	const target = 6;
	const denominations = [1,2,4];

	console.log(solve(target, denominations));
})();
