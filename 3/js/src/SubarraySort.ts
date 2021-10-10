function subarraySort(list: number[]): [number, number] {
	const n = list.length;

	let min = Number.POSITIVE_INFINITY;
	let max = Number.NEGATIVE_INFINITY;

	for(let i=0; i<n; i++) {
		if(isOutOfOrder(i, list)) {
			min = Math.min(min, list[i]);
			max = Math.max(max, list[i]);
		}
	}

	const res: [number, number] = [-1, -1];
	if(min == Number.POSITIVE_INFINITY) return res;

	let i=0;
	while(list[i] <= min) {
		res[0] = ++i;
	}

	i=n-1;
	while(list[i] >= max) {
		res[1] = --i;
	}

	return res;
}

function isOutOfOrder(i: number, list: number[]): boolean {
	if(i == 0) {
		return list[i] > list[i+1];
	} else if(i == list.length-1) {
		return list[i-1] > list[i];
	} else {
		return list[i] > list[i+1] || list[i-1] > list[i];
	}
}

(function main() {
	const list = [1,2,4,7,10,11,7,12,6,7,16,18,19];
	console.log(subarraySort(list));
})();
