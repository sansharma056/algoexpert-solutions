function insertionSort(list: number[]) {
	const n = list.length;

	for(let i=1; i<n; i++) {
		const key = list[i];

		let j = i-1;
		while(j >=0 && list[j] > key) {
			list[j+1] = list[j];
			j--;
		}

		list[j+1] = key;
	}

}

(function main() {
	const list = [7,3,5,1,8,4,3];
	insertionSort(list);
	console.log(list);
})();
