function getPairs(list: number[], target: number): number[][] {
	const n = list.length;
	const map: Map<number, [number, number][]> = new Map();
	const res: number[][] = [];

	for(let i=0; i<n-1; i++) {
		for(let j=i+1; j<n; j++) {
			const x = list[i];
			const y = list[j];

			if(map.has(target-(x+y))) {
				for(const pair of map.get(target-(x+y))!) {
					res.push([...pair, x, y]);
				}
			}
		}

		for(let j=0; j<i; j++) {
			const x = list[i] + list[j];
			const pair: [number, number] = [list[i], list[j]];
			if(map.has(x)) {
				map.get(x)!.push(pair);
			} else {
				map.set(x, [pair]);
			}
		}
	}

	return res;
}

(function main() {
	const list = [7,6,4,-1,1,2];
	const target = 16;

	console.log(getPairs(list, target));
})();
