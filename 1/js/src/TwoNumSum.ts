function solve(arr: number[], target: number): number[] {
	const found = new Map(); 	

	for(const x of arr) {
		const y = target - x;	

		if(found.has(y)) {
			return [x, y];
		} else {
			found.set(x, true);
		}
	}


	return [-1,-1];
}

(function main() {
	const arr = [3,5,-4,8,11,1,-1,6];
	const target = 10;

	console.log(solve(arr,target));
})();
