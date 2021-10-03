import {Vertex, Graph} from "./Graph";

function dfs(graph: Graph<string>): string[] {
	let vertices: string[] = [];	
	
	const root = graph.getVertexByData("A");
	if(root != null) {
		dfsHelper(root, vertices);
	}

	return vertices;
}

function dfsHelper(vertex: Vertex<string>, vertices: string[]): void {
	vertices.push(vertex.data);
	
	for(const child of vertex.children) {
		dfsHelper(child, vertices);
	}
}

(function main() {
	const graph: Graph<string> = new Graph<string>();	
	
	graph.addEdge("A", "B");
	graph.addEdge("A", "C");
	graph.addEdge("A", "D");

	graph.addEdge("B", "E");
	graph.addEdge("B", "F");

	graph.addEdge("D", "G");
	graph.addEdge("D", "H");


	graph.addEdge("F", "I");
	graph.addEdge("F", "J");

	graph.addEdge("G", "K");
	
	console.log(dfs(graph));
})();
