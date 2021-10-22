function quickselect(list: number[], k: number): number {
	let first = 1;
	let last = list.length - 1;

	while (true) {
		let pivot = first - 1;

		while (first <= last) {
			if (list[first] > list[pivot] && list[last] < list[pivot]) {
				swap(first, last, list);
			}

			if (list[first] <= list[pivot]) {
				first++;
			}
			if (list[last] >= list[pivot]) {
				last--;
			}
		}

		swap(last, pivot, list);

		if (k - 1 == last) {
			return list[k - 1];
		}

		if (last < k - 1) {
			first = last + 2;
			last = list.length - 1;
		} else {
			first = 1;
			last--;
		}
	}
}

function swap(i: number, j: number, list: number[]) {
	[list[i], list[j]] = [list[j], list[i]];
}

(function main() {
	const list = [8, 5, 2, 9, 7, 6, 3];
	const k = 3;

	console.log(quickselect(list, k));
})();
