function isMonotonicArray(list: number[]): boolean {
	if(list.length == 1) {
		return true;
	}

	let isNonIncr = true;
	let isNonDecr = true;

	for(let i=1; i<list.length; i++) {
		if(list[i-1] > list[i]) {
			isNonDecr = false;
		}

		if(list[i-1] < list[i]) {
			isNonIncr = false;
		}
	}

	return isNonDecr || isNonIncr;
}

(function main() {
	const list = [-1,-5,-10,-1100,-1100,-1101,-1102,-9001];
	console.log(isMonotonicArray(list));
})();
