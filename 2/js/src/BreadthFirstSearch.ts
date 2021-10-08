import {Vertex, Graph} from "./Graph";

function bfs(graph: Graph<string>): string[] {
	let res: string[] = [];

	const root =  graph.getVertexByData("A");

	if(root != null) {
		let queue: Vertex<string>[] = [];
		queue.push(root);

		while(queue.length != 0) {
			const vertex = queue.shift()!;
			res.push(vertex.data);

			for(const child of vertex.children) {
				queue.push(child);
			}
		}
	}

	return res;
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

	console.log(bfs(graph));
})();
