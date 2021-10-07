function solve(source: string, target: string): number {
	const n = source.length;
	const m = target.length;

	let edits: number[][] = [];

	for(let i=0; i<=n; i++) {
		edits.push([]);
	}

	for(let i=0; i<=m; i++) {
		edits[0][i] = i;
	}

	for(let i=0; i<=n; i++) {
		edits[i][0] = i;
	}

	for(let i=1; i<=n; i++) {
		for(let j=1; j<=m; j++) {
			if(source.charAt(i-1) == target.charAt(j-1)) {
				edits[i][j] = edits[i-1][j-1];
			} else {
				edits[i][j] = Math.min(edits[i-1][j], edits[i][j-1], edits[i-1][j-1]) + 1;
			}
		}
	}

	return edits[n][m];
}

(function main() {
	const source = "abc";
	const target = "yabd";

	console.log(solve(source, target));
})();
