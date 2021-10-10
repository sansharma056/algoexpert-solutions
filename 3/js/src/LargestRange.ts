function getLargestRange(list: number[]): [number, number] {
	const n = list.length;

	const map: Map<number, boolean> = new Map();
	list.forEach(i => map.set(i, false));

	const max: [number, number] = [-1,-1];

	for(let i=0; i<n; i++) {
		if(!map.get(list[i]))	{
			const range = getRange(list[i], map);
			if(range[1] - range[0] >= max[1] - max[0]) {
				[max[0], max[1]] = range;
	 		}
		}
	}

	return max;
}

function getRange(num: number, map: Map<number, boolean>): [number, number] {
	map.set(num, true);

	const range: [number, number] = [num, num];

	let left = num-1;
	while(map.has(left) && !map.get(left)) {
		map.set(left, true);
		range[0] = left--;
	}

	let right = num+1;
	while(map.has(right) && !map.get(right)) {
		map.set(right, true);
		range[1] = right++;
	}

	return range;
}

(function main() {
	const list = [1,11,3,0,15,5,2,4,10,7,12,6];
	console.log(getLargestRange(list));
})();
