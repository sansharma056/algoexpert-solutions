import java.util.Deque;
import java.util.ArrayDeque;

class ShortenPath {
	public static String shortenPath(String path) {
		String pathElements[] = path.split("/");
		StringBuilder shortestPath = new StringBuilder();
	
		Deque<String> stack = new ArrayDeque<>();

		for(String ele : pathElements) {
			if(ele.equals("..")) {
				if(!stack.isEmpty()) {
					stack.pop();
				}
			} else if(!ele.equals(".") && !ele.equals("")) {
					stack.push(ele);
			}
		}
		
		if(stack.isEmpty()) {
			return "/";
		}
		
		while(!stack.isEmpty()) {
			shortestPath.insert(0, stack.pop());
			shortestPath.insert(0, "/");
		}

		return shortestPath.toString();
	}

	public static void main(String args[]) {
		String paths[] = {"/home/", "/../", "/home//foo/", "/a/./b/../../c/", "/", "/foo/../test/../test/../foo//bar/./baz"};

		for(String path : paths) {
			System.out.println(shortenPath(path));
		}
	}
}
