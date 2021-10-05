function getFibonacci(i: number) {
	const memo = new Map<number, number>();

	return getFibonacciHelper(Math.abs(i), memo);
}


function getFibonacciHelper(i: number, memo: Map<number, number>): number {
	if(i <= 1) {
		return i;
	}

	let fib = memo.get(i);

	if(fib == undefined) {
		fib = getFibonacciHelper(i-1, memo) + getFibonacciHelper(i-2, memo);
		memo.set(i, fib);

	}

	return fib;
}

(function main() {
	console.log(getFibonacci(1));

})();
