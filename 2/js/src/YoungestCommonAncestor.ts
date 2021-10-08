class Vertex {
	data: String
	ancestor: Vertex | null

	constructor(data: string) {
		this.data = data;
		this.ancestor= null;
	}
}

function addVertex(vertices: Vertex[], vertexData: string, ancestorData?: string) {
	let vertex = getVertex(vertices, vertexData);
	if(vertex == null) {
		vertex = new Vertex(vertexData);
		vertices.push(vertex);
	}

	if(ancestorData != undefined) {
		let ancestor = getVertex(vertices, ancestorData);
		if(ancestor == null) {
			ancestor = new Vertex(ancestorData);
			vertices.push(ancestor);
		}

		vertex.ancestor = ancestor;
	}
}

function getVertex(vertices: Vertex[], data: string): Vertex | null {
	for(const vertex of vertices) {
		if(vertex.data == data) return vertex;
	}

	return null;
}

function getVertexDepth(vertex: Vertex): number {
	let depth = 0;

	let cur = vertex;
	while(cur.ancestor !=  null) {
		depth++;
		cur = cur.ancestor;
	}

	return depth;
}

function ascendToSameDepth(vertex: Vertex, diff: number): Vertex {
	while(diff > 0) {
		vertex = vertex.ancestor!;
		diff--;
	}

	return vertex;
}

function getYoungestCommonAncestor(vertices: Vertex[], descendantOne: Vertex, descendantTwo: Vertex) {
	const depthOne = getVertexDepth(descendantOne);
	const depthTwo = getVertexDepth(descendantTwo);

	const diff = Math.abs(depthOne - depthTwo);

	if(depthOne > depthTwo) {
		descendantOne = ascendToSameDepth(descendantOne, diff);
	} else {
		descendantTwo = ascendToSameDepth(descendantTwo, diff);
	}

	if(descendantOne == descendantTwo) {
		return descendantOne;
	}

	while(descendantOne.ancestor != descendantTwo.ancestor) {
		descendantOne = descendantOne.ancestor!;
		descendantTwo = descendantTwo.ancestor!;
	}

	return descendantOne.ancestor;
}

(function main() {
	const vertices: Vertex[] = [];

	addVertex(vertices, "B", "A");
	addVertex(vertices, "C", "A");
	addVertex(vertices, "D", "A");
	addVertex(vertices, "E", "A");
	addVertex(vertices, "F", "A");

	addVertex(vertices, "G", "B");
	addVertex(vertices, "H", "B");
	addVertex(vertices, "I", "B");

	addVertex(vertices, "J", "C");

	addVertex(vertices, "K", "D");
	addVertex(vertices, "L", "D");

	addVertex(vertices, "M", "F");
	addVertex(vertices, "N", "F");

	addVertex(vertices, "O", "H");
	addVertex(vertices, "P", "H");
	addVertex(vertices, "Q", "H");
	addVertex(vertices, "R", "H");

	addVertex(vertices, "T", "P");
	addVertex(vertices, "U", "P");

	addVertex(vertices, "V", "R");

	addVertex(vertices, "W", "V");
	addVertex(vertices, "X", "V");
	addVertex(vertices, "Y", "V");

	addVertex(vertices, "Z", "X");

	const descendantOne = getVertex(vertices, "Y");
	const descendantTwo = getVertex(vertices, "F");

	console.log(getYoungestCommonAncestor(vertices, descendantOne!, descendantTwo!));
})();
