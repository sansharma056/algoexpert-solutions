function searchForRange(list: number[], target: number): [number, number] {
	const range: [number, number] = [-1, -1];
	searchForRangeHelper(0, list.length - 1, target, list, range, true);
	searchForRangeHelper(0, list.length - 1, target, list, range, false);
	return range;
}

function searchForRangeHelper(
	start: number,
	end: number,
	target: number,
	list: number[],
	range: [number, number],
	goLeft: boolean
) {
	while (start <= end) {
		const mid = Math.floor((start + end) / 2);

		if (target < list[mid]) {
			end = mid - 1;
		} else if (target > list[mid]) {
			start = mid + 1;
		} else {
			if (goLeft) {
				if (mid == 0 || list[mid] != list[mid - 1]) {
					range[0] = mid;
					return;
				} else {
					end = mid - 1;
				}
			} else {
				if (mid == list.length - 1 || list[mid] != list[mid + 1]) {
					range[1] = mid;
					return;
				} else {
					start = mid + 1;
				}
			}
		}
	}
}

(function main() {
	const list = [0, 1, 21, 33, 45, 45, 45, 45, 45, 45, 61, 71, 73];
	const target = 45;

	console.log(searchForRange(list, target));
})();
