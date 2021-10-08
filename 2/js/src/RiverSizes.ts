function getRiverSizes(matrix: number[][]): number[] {
	let visited = matrix.map(row => row.map(() => false));
	let sizes: number[] = [];

	for(let i=0; i<matrix.length; i++) {
		for(let j=0; j<matrix[0].length; j++) {
			if(!visited[i][j]) explore(i, j, matrix, visited, sizes);
		}
	}

	return sizes;
}

function explore(i: number, j: number, matrix: number[][], visited: boolean[][], sizes: number[]) {
	if(matrix[i][j] == 0) {
		visited[i][j] = true;
		return;
	}

	let curSize = 0;

	let queue: number[][] = [[i,j]];

	while(queue.length != 0) {
		const cur = queue.shift()!;
		const [x,y] = cur;

		visited[x][y] = true;

		if(matrix[x][y] == 0) continue;

		curSize++;

		const neighbours = getUnvisitedNeighbours(cur[0], cur[1], matrix, visited);
		for(const neighbour of neighbours) {
			queue.push(neighbour);
		}
	}

	if(curSize > 0) {
		sizes.push(curSize);
	}
}

function getUnvisitedNeighbours(i: number, j: number, matrix: number[][], visited: boolean[][]): number[][] {
	const xDir = [0,0,1,-1];
	const yDir = [1,-1,0,0];

	let neighbours = [];

	for(let k=0; k<4; k++) {
		const x = i + xDir[k];
		const y = j + yDir[k];

		if( (x >= 0 && x < matrix.length) && (y >= 0 && y < matrix[0].length) ) {
			if(!visited[x][y]) {
				neighbours.push([x,y]);
			}
		}
	}

	return neighbours;
}

(function main() {
	const matrix = [ [1,0,0,1,0], [1,0,1,0,0], [0,0,1,0,1], [1,0,1,1,0] ];
	console.log(getRiverSizes(matrix));
})();
