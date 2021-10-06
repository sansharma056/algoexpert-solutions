function solve(list: number[], target: number): (number[])[] {
	const n = list.length;

	list.sort((a, b) => a-b);

	let res: (number[])[] = [];
	for(let i=0; i<list.length-2; i++) {
		const x = list[i];

		let left = i+1;
		let right = n-1;

		while(left < right) {
			const y = list[left];
			const z = list[right];

			if(x + y + z < target) {
				left++;
			} else if(x + y + z > target) {
				right--;
			} else {
				res.push([x,y,z,]);
				left++;
				right--;
			}
		}
	}

	return res;
}

(function main() {
	const list = [12,3,1,2,-6,5,-8,6];
	const target = 0;

	console.log(solve(list, target));
})();
