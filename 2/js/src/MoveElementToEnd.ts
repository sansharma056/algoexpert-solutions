function swap(i: number, j: number, list: number[]) {
	const temp = list[i];
	list[i] = list[j];
	list[j] = temp;
}

function solve(list: number[], toMove: number) {
	const n = list.length;

	let i=0;
	let j=n-1;

	while(i < n && i < j) {
		if(list[i] == toMove) {
			while(list[j] == toMove && i < j) {
				j--;
			}

			swap(i, j, list);
			j--;
		}

		i++;
	}
}

(function main() {
	const list = [2,1,2,2,2,3,4,2];
	const toMove = 2;

	solve(list, toMove);
	console.log(list);
})();
