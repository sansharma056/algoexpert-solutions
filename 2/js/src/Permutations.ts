function swap(i: number, j: number, list: number[]) {
	[list[i], list[j]] = [list[j], list[i]];
}

function getPermutations(list: number[]): number[][] {
	const permutations: number[][] = [];
	getPermutationsHelper(0, list, permutations);
	return permutations;
}

function getPermutationsHelper(i: number, list: number[], permutations: number[][]) {
	if(i == list.length - 1) {
		permutations.push(Array.from(list));
	}

	for(let j=i; j<list.length; j++) {
		swap(i, j, list);
		getPermutationsHelper(i+1, list, permutations);
		swap(i, j, list);
	}
}

(function main() {
	const list = [1,2,3];

	console.log(getPermutations(list));
})();
