type Disk = [number, number, number];

function getDisks(disks: Disk[], seq: number[], i: number): Disk[] {
	const res: Disk[] = [];

	while(i != -1) {
		res.unshift(disks[i]);
		i = seq[i];
	}

	return res;
}

function isStrictlyDec(x: Disk, y: Disk): boolean {
	if(x[0] < y[0] && x[1] < y[1] && x[2] < y[2]) {
		return true;
	}

	return false;
}

function diskStacking(disks: Disk[]) {
	const n = disks.length;
	disks.sort((a,b) => a[2] - b[2]);

	const heights: number[] = disks.map(disk => disk[2]);
	const seq: number[] = Array(disks.length).fill(-1);
	let maxIdx = 0;

	for(let i=0; i<n; i++) {
		for(let j=0; j<i; j++) {
			if(isStrictlyDec(disks[j], disks[i])) {
				if(heights[i] <= disks[i][2] + heights[j]) {
					heights[i] = disks[i][2] + heights[j];
					seq[i] = j;
				}
			}
		}
		if(heights[maxIdx] < heights[i]) {
			maxIdx = i;
		}
	}

	return getDisks(disks, seq, maxIdx);
}

(function main() {
	const disks: Disk[] = [ [2,1,2], [3,2,3], [2,2,8], [2,3,4], [2,2,1], [4,4,5] ];

	console.log(diskStacking(disks));
})();
