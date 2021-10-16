import { Heap } from "./Heap";

function balanceHeaps(minHeap: Heap, maxHeap: Heap) {
	const diff = Math.abs(minHeap.length() - maxHeap.length());

	if (diff <= 1) {
		return;
	}

	if (minHeap.length < maxHeap.length) {
		minHeap.insert(maxHeap.remove());
	} else {
		maxHeap.insert(minHeap.remove());
	}
}

function getMedian(minHeap: Heap, maxHeap: Heap): number {
	const minHeapLength = minHeap.length();
	const maxHeapLength = maxHeap.length();

	if (minHeapLength == maxHeapLength) {
		return (minHeap.peek() + maxHeap.peek()) / 2;
	}

	if (minHeapLength > maxHeapLength) {
		return minHeap.peek();
	}

	return maxHeap.peek();
}

function continuousMedian(list: number[]): number[] {
	const minHeap = new Heap((a, b) => a < b);
	const maxHeap = new Heap((a, b) => a > b);

	const res: number[] = [];

	for (const num of list) {
		if (maxHeap.isEmpty() || num < maxHeap.peek()) {
			maxHeap.insert(num);
		} else {
			minHeap.insert(num);
		}

		balanceHeaps(minHeap, maxHeap);

		res.push(getMedian(minHeap, maxHeap));
	}

	return res;
}

(function main() {
	const list = [5, 10, 100, 200, 6, 13, 14];

	console.log(continuousMedian(list));
})();
