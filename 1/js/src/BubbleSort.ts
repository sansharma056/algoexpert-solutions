function swap(i: number, j: number, list: number[]) {
	const temp  = list[i];
	list[i] = list[j];
	list[j] = temp;
}


function bubbleSort(list: number[]) {
	const n = list.length;

	for(let i=0; i<n-1; i++) {
		let flag = true;

		for(let j=0; j<n-i-1; j++) {
			if(list[j] > list[j+1]) {
				swap(j, j+1, list);
				flag = false;
			}
		}

		if(flag) {
			break;
		}
	}

}

(function main() {
	const list = [7,3,5,1,8,4,3];
	bubbleSort(list);
	console.log(list);
})();
