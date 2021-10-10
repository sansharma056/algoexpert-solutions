function isSameBST(arrayOne: number[], arrayTwo: number[]): boolean {
	if(arrayOne.length != arrayTwo.length)	{
		return false;
	}

	if(arrayOne.length == 0 && arrayTwo.length == 0) {
		return true;
	}

	if(arrayOne[0] != arrayTwo[0]) {
		return false;
	}

	const arrayOneLeft = getSmaller(arrayOne);
	const arrayTwoLeft = getSmaller(arrayTwo);

	const arrayOneRight = getBiggerOrEqual(arrayOne);
	const arrayTwoRight = getBiggerOrEqual(arrayTwo);

	return isSameBST(arrayOneLeft, arrayTwoLeft) && isSameBST(arrayOneRight, arrayTwoRight);
}

function getSmaller(array: number[]): number[] {
	const res: number[] = [];
	for(let i=1; i<array.length; i++) {
		if(array[i] < array[0]) {
			res.push(array[i]);
		}
	}

	return res;
}

function getBiggerOrEqual(array: number[]): number[] {
	const res: number[] = [];
	for(let i=1; i<array.length; i++) {
		if(array[i] >= array[0]) {
			res.push(array[i]);
		}
	}

	return res;
}
(function main() {
	const arrayOne = [10,15,8,12,94,81,5,2,11];
	const arrayTwo = [10,8,5,15,2,12,11,94,81];

	console.log(isSameBST(arrayOne, arrayTwo));
})();
