type NestedNumbers = number | NestedNumbers[];

function getProductSum(list: NestedNumbers[]): number {
	return getProductSumHelper(list, 1);
}

function getProductSumHelper(list: NestedNumbers[], depth: number): number {
	let sum = 0;

	for(const item of list) {
		if(typeof item == "number") {
			sum += item;
		} else {
			sum += getProductSumHelper(item, depth+1);
		}
	}

	return sum*depth;
}

(function main() {
	const list: NestedNumbers[] = [5,2, [7,-1], 3, [6,[-13,8],4]];
	console.log(getProductSum(list));
})();
