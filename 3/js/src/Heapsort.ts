function swap(i: number, j: number, list: number[]) {
	[list[i], list[j]] = [list[j], list[i]];
}

function siftDown(i: number, list: number[], length: number) {
	while(2*i+1 < length) {
		const left = 2*i + 1;
		const right = 2*i + 2;

		let max = left;

		if(right < length && list[right] > list[left]) {
			max = right;
		}

		if(list[max] < list[i]) {
			return;
		}

		swap(max, i, list);
		i = max;
	}
}

function buildMaxHeap(list: number[]) {
	for(let i=Math.floor(list.length/2)-1; i >= 0 ; i--) {
		siftDown(i, list, list.length);
	}
}

function sort(list: number[]) {
	buildMaxHeap(list);

	for(let i=list.length-1; i>0; i--) {
		swap(0, i, list);
		siftDown(0, list, i);
	}
}

(function main() {
	const list = [8,5,2,9,5,6,3];
	sort(list);
	console.log(list);
})();
