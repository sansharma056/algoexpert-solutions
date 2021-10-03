class Vertex<T> {
	data: T
	children: Vertex<T>[]

	constructor(data: T) {
		this.data = data;
		this.children = [];
	}
}

class Graph<T> {
	vertices: Vertex<T>[]
	
	constructor() {
		this.vertices = [];
	}
	
	getVertexByData(data: T): Vertex<T> | null {
		for(const vertex of this.vertices) {
			if(vertex.data == data) {
				return vertex;
			}
		}
		
		return null;
	}
	 
	addVertex(data: T) {
		const vertex = new Vertex<T>(data);
		this.vertices.push(vertex);

		return vertex;
	}
	
	addEdge(from: T, to: T) {
		let fromVertex = this.getVertexByData(from);	
		if(fromVertex == null) {
			fromVertex = this.addVertex(from);
		}	
		
		let toVertex = this.getVertexByData(to);
		if(toVertex == null) {
			toVertex = this.addVertex(to);
		}

		fromVertex.children.push(toVertex);
	}
}

export {Vertex, Graph};
