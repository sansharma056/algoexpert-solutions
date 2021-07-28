import java.util.ArrayList;
import java.util.List;

class YoungestCommonAncestor {
	List<Node> nodes = new ArrayList<Node>();

	class Node {
		String data;
		Node ancestor = null;

		Node(String data) {
			this.data = data;
		}
	}
	
	public void setOldestAncestor(String data) {
		Node ancestor = new Node(data);
		this.nodes.add(ancestor);
	}
	
	public Node getNode(String data) {
		for(Node node : this.nodes) {
			if(node.data.equals(data)) {
				return node;
			}
		}
		return null;
	}

	public void addNode(String childData, String ancestorData) {
		Node ancestor = null;
		Node child = null;

		for(Node node : this.nodes) {
			if(node.data.equals(ancestorData)) {
				ancestor = node;
			}

			if(node.data.equals(childData)) {
				child = node;
			}
		}
		
		if(ancestor == null) {
			ancestor = new Node(ancestorData);
			this.nodes.add(ancestor);
		}

		if(child == null) {
			child = new Node(childData);
			this.nodes.add(child);
		}

		child.ancestor = ancestor;
	}	
	
	public int getLevel(Node topAncestor, Node descendant) {
		int level = 0;
		
		while(descendant != topAncestor) {
			descendant = descendant.ancestor;
			level++;
		}

		return level;
	}
	
	public Node getSameLevelNode(Node node, int lowerDepth, int upperDepth) {
		
		while(upperDepth > lowerDepth) {
			upperDepth--;
			node = node.ancestor;
		}	
		return node;
	}

	public Node getYoungestCommonAncestor(Node topAncestor, Node descendantOne, Node descendantTwo) {
		int depthOne = getLevel(topAncestor, descendantOne);
		int depthTwo = getLevel(topAncestor, descendantTwo);
		
		if(depthOne < depthTwo) {
			descendantTwo = getSameLevelNode(descendantTwo, depthOne, depthTwo); 
		} else if(depthOne > depthTwo) {
				descendantOne = getSameLevelNode(descendantOne, depthTwo, depthOne);
		}
			
		while(descendantOne.ancestor != descendantTwo.ancestor) {
			descendantOne = descendantOne.ancestor;
			descendantTwo = descendantTwo.ancestor;
		}		
		
		if(descendantOne == descendantTwo) {
			return descendantOne;
		}

		return descendantOne.ancestor;
	}


	public static void main(String args[]) {
		YoungestCommonAncestor y = new YoungestCommonAncestor();
		y.setOldestAncestor("A");

		y.addNode("B", "A");
		y.addNode("C", "A");
		y.addNode("D", "A");
		y.addNode("E", "A");
		y.addNode("F", "A");

		y.addNode("G", "B");
		y.addNode("H", "B");
		y.addNode("I", "B");

		y.addNode("J", "C");
		
		y.addNode("K", "D");
		y.addNode("L", "D");

		y.addNode("M", "F");
		y.addNode("N", "F");

		y.addNode("O", "H");
		y.addNode("P", "H");
		y.addNode("Q", "H");
		y.addNode("R", "H");

		y.addNode("T", "P");
		y.addNode("U", "P");

		y.addNode("V", "R");

		y.addNode("W", "V");
		y.addNode("X", "V");
		y.addNode("Y", "V");

		y.addNode("Z", "X");
		
		Node A = y.getNode("A"); 
		Node descendantOne = y.getNode("V");
		Node descendantTwo = y.getNode("Z");

		System.out.println(y.getYoungestCommonAncestor(A, descendantOne, descendantTwo).data);
	}

}
