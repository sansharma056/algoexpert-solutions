function generatePowerset(list: number[]): number[][] {
	const powerset: number[][] = [];
	powerset.push([]);

	for(const num of list) {
		const sets: number[][] = [];

		const length = powerset.length;
		for(let i=0; i<length; i++) {
			const set = powerset[i];
			powerset.push(set.concat(num));
		}
	}

	return powerset;
}

(function main() {
	const list = [1,2,3];
	console.log(generatePowerset(list));
})();
