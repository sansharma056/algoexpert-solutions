interface Frame {
	cur: number;
	max: number;
	min: number;
}

class MinMaxStack {
	stack: Frame[]

	constructor() {
		this.stack = [];
	}

	peek(): Frame {
		return this.stack[this.stack.length-1];
	}

	pop(): Frame | undefined {
		return this.stack.pop();
	}

	push(data: number) {
		if(this.peek() == undefined) {
			this.stack.push({cur: data, max: data, min: data});
		} else {
			this.stack.push({cur: data, max: Math.max(this.getMax(), data), min: Math.min(this.getMin(), data)});
		}
	}

	getMax() {
		const frame = this.peek();
		if(frame) return frame.max;
		return -1;
	}

	getMin() {
		const frame = this.peek();
		if(frame) return frame.min;
		return -1;
	}
}
