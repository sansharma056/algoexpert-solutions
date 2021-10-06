function swap(i: number, j: number, list: number[]) {
	if (i==j) return;

	const temp = list[i];
	list[i] = list[j];
	list[j] = temp;
}

function selectionSort(list: number[]) {
	const n = list.length;

	for(let i=0; i<n-1; i++) {
		let minIdx = i;

		for(let j=i+1; j<n; j++) {
			if(list[j] < list[minIdx]) {
				minIdx = j;
			}
		}

		swap(minIdx, i, list);
	}
}

(function main() {
	const list = [7,3,5,1,8,4,3];
	selectionSort(list);
	console.log(list);
})();
