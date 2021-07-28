import java.util.ArrayList;

public class Graph<E> {
	ArrayList<Vertex> vertices;	
	
	public Graph() {
		vertices = new ArrayList<Vertex>();
	}
	
	public class Vertex {
		E data;
		ArrayList<Vertex> adjacenctVertices;

		public Vertex(E data) {
			this.adjacenctVertices = new ArrayList<Vertex>();
			this.data = data;
		}

		public void addAdjacentVertex(Vertex to) {
			for(Vertex v : this.adjacenctVertices) {
				if(v.data == to.data) {
					return;
				}
			}
			this.adjacenctVertices.add(to);	
		}	
		
		public E getData() {
			return this.data;
		}

		public ArrayList<Vertex> getAdjacentVertices() {
			return this.adjacenctVertices;
		}
	}
	
	public Vertex getVertex(E data) {
		for(Vertex v : this.vertices ) {
			if(v.data == data) {
				return v;
			}
		}
		return null;
	}
	
	public void addEdge(E from, E to) {
		Vertex fromV, toV;
		fromV = toV = null;

		for(Vertex v : this.vertices) {
			if(v.data == from) {
				fromV = v;
			}
			else if (v.data == to) {
				toV = v;
			}

			if(fromV != null && toV != null) {
				break;
			}
		}

			if(fromV == null) {
				fromV = new Vertex(from);
				this.vertices.add(fromV);
			}
		
			if(toV == null) {
				toV = new Vertex(to);
				this.vertices.add(toV);
			}
			
			fromV.addAdjacentVertex(toV);
	}
	
}

