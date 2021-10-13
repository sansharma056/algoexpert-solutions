function minNumberOfJumps(list: number[]): number {
	const n = list.length;

	if(n == 1) return 0;

	let steps = list[0];
	let jumps = 0;
	let maxJump = list[0];

	for(let i=1; i<n-1; i++) {
		steps--;
		maxJump = Math.max(maxJump, i + list[i]);
		if(steps == 0) {
			jumps++;
			steps = maxJump - i;
		}
	}

	return jumps+1;
}

(function main() {
	const list = [3,4,2,1,2,3,7,1,1,1,3];
	console.log(minNumberOfJumps(list))
})();
