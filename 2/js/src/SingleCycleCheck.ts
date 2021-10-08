function solve(list: number[]): boolean {
	const n = list.length;
	let i = 0;
	let visited = 0;

	while(visited < n) {
		if(i == 0 && visited > 0) {
			return false;
		}

		visited++;
		let nextIdx = (i + list[i]) % n;
		if(nextIdx < 0) {
			nextIdx = n + nextIdx;
		}

		i = nextIdx;
	}

	if(i == 0 && visited == n) {
		return true;
	}

	return false;
}

(function main() {
	const list = [2,3,1,-4,-4,2];
	console.log(solve(list));
})();
