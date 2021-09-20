import java.util.HashMap;
import java.util.Map;

class ShortenPath {
	public static String shortenPath(String path) {
		String pathElements[] = path.split("/");
		StringBuilder shortestPath = new StringBuilder(); 

		Tree tree = new Tree();	
		Tree.Node cur = null;	

		for(String ele : pathElements) {
			if(tree.root == null) {
				tree.root = new Tree.Node(null, ele);
				cur = tree.root;
			} else if(ele.equals("..")) {
					if(cur.parent != null) {
						cur = cur.parent;	
					}
			} else if(ele.equals(".") || ele.equals("")) {
					continue;
			}	else {
				if(!cur.children.containsKey(ele)) {
					cur.children.put(ele, new Tree.Node(cur, ele));
				}

				cur = cur.children.get(ele);
			}
		}
		
		if(cur == null) return "/";

		while(cur.parent != null) {
			if(shortestPath.length() != 0) {
				shortestPath.insert(0, "/");
				shortestPath.insert(0, cur.data);
			} else {
					shortestPath.append(cur.data);
			}

			cur = cur.parent;
		} 
			
		shortestPath.insert(0, "/");

		return shortestPath.toString(); 
	}	

	public static void main(String args[]) {
		String paths[] = {"/home/", "/../", "/home//foo/", "/a/./b/../../c/", "/", "/foo/../test/../test/../foo//bar/./baz"};

		for(String path : paths) {
			System.out.println(shortenPath(path));
		}
	}
}

class Tree {
	Node root;
	
	static class Node {
		Node parent;
		String data;
		Map<String, Node> children;

		Node(Node parent, String data) {
			this.parent = parent;
			this.data = data;
			children = new HashMap<>();
		}
	}
}
