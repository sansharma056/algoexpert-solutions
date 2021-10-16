type Compare = (a: number, b: number) => boolean;

class Heap {
	heap: number[];
	compare: Compare;

	constructor(compare: Compare) {
		this.heap = [];
		this.compare = compare;
	}

	length(): number {
		return this.heap.length;
	}

	isEmpty(): boolean {
		if (this.heap.length == 0) {
			return true;
		}

		return false;
	}

	swap(i: number, j: number) {
		[this.heap[i], this.heap[j]] = [this.heap[j], this.heap[i]];
	}

	siftUp(i: number) {
		while (i > 0) {
			const parent = Math.floor((i - 1) / 2);

			let newIdx = parent;

			if (this.compare(this.heap[i], this.heap[newIdx])) {
				newIdx = i;
			}

			if (newIdx == parent) {
				return;
			}

			this.swap(parent, i);
			i = parent;
		}
	}

	siftDown(i: number) {
		while (2 * i + 1 < this.heap.length) {
			const left = 2 * i + 1;
			const right = 2 * i + 2;

			let newIdx = left;

			if (
				right < this.heap.length &&
				this.compare(this.heap[right], this.heap[newIdx])
			) {
				newIdx = right;
			}

			if (this.compare(this.heap[i], this.heap[newIdx])) {
				return;
			}

			this.swap(newIdx, i);
			i = newIdx;
		}
	}

	insert(data: number) {
		this.heap.push(data);
		this.siftUp(this.heap.length - 1);
	}

	remove(): number {
		if (this.heap.length == 0) {
			return -1;
		}

		this.swap(0, this.heap.length - 1);
		const removed = this.heap.pop()!;
		this.siftDown(0);

		return removed;
	}

	peek(): number {
		if (this.heap.length == 0) {
			return -1;
		}

		return this.heap[0];
	}
}

export { Heap };
