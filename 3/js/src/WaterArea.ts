function waterArea(list: number[]): number {
	const n = list.length;

	const lMax: number[]  = [0];
	for(let i=1; i<n; i++) {
		lMax[i] = Math.max(lMax[i-1], list[i-1]);
	}

	const rMax: number[] = [];
	rMax[n-1] = 0;
	for(let i=n-2; i>=0; i--) {
		rMax[i] = Math.max(rMax[i+1], list[i+1]);
	}

	let area = 0;
	for(let i=0; i<n; i++) {
		const min = Math.min(lMax[i], rMax[i]);
		if(min > list[i]) {
			area += min - list[i];
		}
	}

	return area;
}

(function main() {
	const list = [0,8,0,0,5,0,0,10,0,0,1,1,0,3];
	console.log(waterArea(list));
})();
