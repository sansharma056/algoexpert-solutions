function getPeakSize(i: number, list: number[]): number {
	let j;
	let length = 1;

	j = i-1;
	while(j >= 0 && list[j] < list[j+1]) {
		length++;
		j--;
	}

	j = i+1;
	while(j < list.length && list[j] < list[j-1])	{
		length++;
		j++;
	}

	return length;
}

function getLongestPeak(list: number[]): number {
	let longest = 0;

	let i = 1;
	while(i < list.length-1) {
		const isPeak = list[i-1] < list[i] && list[i]	> list[i+1];

		if(!isPeak) {
			i++;
			continue;
		}

		longest = Math.max(longest, getPeakSize(i, list));
		i++;
	}

	return longest;
}

(function main() {
	const list =	[1,2,3,3,4,0,10,6,5,-1,-3,2,3];

	console.log(getLongestPeak(list));
})();
