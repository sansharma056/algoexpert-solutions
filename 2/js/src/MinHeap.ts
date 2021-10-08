class MinHeap {
	heap: number[]

	constructor(dataArr ?: number[]) {
		if(dataArr != undefined) {
			this.heap = dataArr;
			this.buildHeap();
		} else {
			this.heap = [];
		}
	}

	swap(i: number, j: number) {
		const temp = this.heap[i];
		this.heap[i] = this.heap[j];
		this.heap[j] = temp;
	}

	getMin(i: number, j: number) {
		if(this.heap[i] < this.heap[j]) {
			return i;
		}
		return j;
	}

	buildHeap() {
		for(let i=Math.floor(this.heap.length/2 - 1); i>=0; i--) {
			this.siftDown(i);
		}
	}

	siftDown(i: number) {
		while(2*i + 1 < this.heap.length) {
			const left = 2*i + 1;
			const right = 2*i + 2;
			let min = left;

			if(right < this.heap.length) {
				min = this.getMin(left, right);
			}

			min = this.getMin(i, min);
			if(min == i) {
				return;
			}

			this.swap(min, i);
			i = min;
		}
	}

	siftUp(i: number) {
		while(i > 0) {
			const parent = Math.floor((i-1)/2);
			const min = this.getMin(parent, i);

			if(min == parent) {
				return;
			}

			this.swap(i, parent);
			i = parent;
		}
	}

	insert(data: number) {
		this.heap.push(data);
		this.siftUp(this.heap.length-1);
	}

	remove(): number {
		this.swap(0, this.heap.length-1);

		const deleted = this.heap.pop();
		if(deleted == undefined) {
			return -1;
		}

		this.siftDown(0);
		return deleted;
	}
}

export {MinHeap};
