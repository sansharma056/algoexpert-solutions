function getSmallestDifference(list1: number[], list2: number[]): [number, number] {
	list1.sort((a,b) => a-b);
	list2.sort((a,b) => a-b);

	let res: [number, number] = [0, Number.MIN_SAFE_INTEGER];
	let ptr1 = 0;
	let ptr2 = 0;

	while(ptr1 < list1.length && ptr2 < list2.length) {
		const x = list1[ptr1];
		const y = list2[ptr2];

		const diff = Math.abs(x - y);
		if(diff <= Math.abs(res[1] - res[0]))	{
			res[0] = x;
			res[1] = y;
		}

		if(x < y) {
			ptr1++;
		} else if(x > y) {
			ptr2++;
		} else {
			return [x,y];
		}
	}

	return res;
}

(function main() {
	const list1 = [-1,5,10,20,28,3];
	const list2 = [26,134,135,15,17];

	console.log(getSmallestDifference(list1, list2));
})();
