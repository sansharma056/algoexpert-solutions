function getThreeLargestNumbers(list: number[]): number[] {
	let res: number[] = [Number.NEGATIVE_INFINITY, Number.NEGATIVE_INFINITY, Number.NEGATIVE_INFINITY];

	for(const num of list) {
		if(num > res[2]) {
			res[0] = res[1];
			res[1] = res[2];
			res[2] = num;
		} else if(num > res[1]) {
			res[0] = res[1];
			res[1] = num;
		} else if(num > res[0]) {
			res[0] = num;
		}
	}

	return res;
}

(function main() {
	const list = [141,1,17,-7,-17,-27,18,541,8,7,7];

	console.log(getThreeLargestNumbers(list));
})();
