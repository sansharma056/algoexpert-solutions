function search(list: number[], x: number): number {
	let first = 0;
	let last = list.length-1;

	while(first <= last) {
		const mid = Math.floor((first + last));

		if(list[mid] == x) {
			return mid;
		} else if(x < list[mid]) {
			last = mid - 1;
		} else {
			first = mid + 1;
		}
	}

	return -1;
}


(function main() {
	const list = [1,3,4,5,7,8];
	const x = 5;

	console.log(search(list, x));
})();
