//TODO: change type of nested list to a less cursed one
function getProductSum(list: (number | (number | number[])[])[]): number {
	return getProductSumHelper(list, 1);
}

function getProductSumHelper(list: (number | (number | number[])[])[], depth: number): number {
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
	const list = [5,2, [7,-1], 3, [6,[-13,8],4]];
	console.log(getProductSum(list));

})();
