function generateSeq(list: number[], seq: number[], i: number): number[] {
	const res: number[] = [];

	while(i != -1) {
		res.unshift(list[i]);
		i = seq[i];
	}

	return res;
}

function maxSumIncreasingSubsequence(list: number[]): number[] {

	const n = list.length;
	const seq: number[] = Array(list.length).fill(-1);
	const res: number[] = Array.from(list);

	let maxIdx = 0;

	for(let i=1; i<n; i++) {
		for(let j=0; j<i; j++) {
			if(list[j] < list[i]) {
				if(res[i] < res[j] + list[i] ) {
					res[i] = res[j] + list[i];
					seq[i] = j;
				}
			}

		}

		if(res[i] > res[maxIdx]) {
			maxIdx = i;
		}
	}

	return generateSeq(list, seq, maxIdx);
}

(function main() {
	const list = [8,12,2,3,15,5,7];
	console.log(maxSumIncreasingSubsequence(list));
})();
