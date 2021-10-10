function minRewards(list: number[]): number {
	const n = list.length;
	const rewards: number[] = list.map( () => 1 );

	for(let i=1; i<n; i++) {
		if(list[i-1] < list[i]) {
			rewards[i] =  rewards[i-1] + 1;
		}
	}

	for(let i=n-2; i>=0; i--) {
		if(list[i] > list[i+1]) {
			rewards[i] = Math.max(rewards[i], rewards[i+1] + 1);
		}
	}

	return rewards.reduce((i, sum) => sum += i, 0);
}

(function main() {
	const list = [8,4,2,1,3,6,7,9,5];
	console.log(minRewards(list));
})();
