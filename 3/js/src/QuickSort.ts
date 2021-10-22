function quickSort(list: number[]) {
	quickSortHelper(list, 0, list.length - 1);
}

function quickSortHelper(list: number[], first: number, last: number) {
	if (first > last) {
		return;
	}

	const pivotIdx = partition(list, first, last);
	quickSortHelper(list, first, pivotIdx - 1);
	quickSortHelper(list, pivotIdx + 1, last);
}

function partition(list: number[], first: number, last: number): number {
	const pivotIdx = first;
	first++;

	while (first <= last) {
		if (list[first] > list[pivotIdx] && list[last] < list[pivotIdx]) {
			swap(first, last, list);
		}

		if (list[first] <= list[pivotIdx]) {
			first++;
		}

		if (list[last] >= list[pivotIdx]) {
			last--;
		}
	}

	swap(last, pivotIdx, list);

	return last;
}

function swap(i: number, j: number, list: number[]) {
	[list[i], list[j]] = [list[j], list[i]];
}

(function main() {
	const list = [8, 5, 2, 9, 5, 6, 3];
	quickSort(list);
	console.log(list);
})();
