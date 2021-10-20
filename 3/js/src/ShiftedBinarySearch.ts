function shiftedBinarySearch(list: number[], target: number): number {
	let start = 0;
	let end = list.length - 1;

	while (start <= end) {
		let mid = Math.floor((start + end) / 2);

		if (list[mid] == target) {
			return mid;
		}

		if (list[start] <= list[mid - 1]) {
			if (target >= list[start] && target < list[mid - 1]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		} else {
			if (target <= list[end] && target > list[mid + 1]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
	}

	return -1;
}

(function main() {
	const list = [45, 61, 71, 72, 73, 0, 1, 21, 33, 45];
	const target = 33;

	console.log(shiftedBinarySearch(list, target));
})();
