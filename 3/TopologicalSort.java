import java.util.ArrayList;
import java.util.List;

public class TopologicalSort {

	public static List<Integer> getOrder(List<Integer> jobs, List<List<Integer>> dependencies) {
		List<Integer> order = new ArrayList<>();
		Graph graph = new Graph();	

		for(List<Integer> dependency : dependencies) {
			graph.insertEdge(dependency.get(0), dependency.get(1));
		}
		
		for(int data : jobs) {
			boolean containsCycle = getOrder(graph, graph.search(data), order);
			if(containsCycle) {
				return List.of();
			}
		}

		return order;
	}
	
	public static boolean getOrder(Graph graph, Graph.Node cur, List<Integer> order) {
		if(cur.visited) {
			return false;
		}
		
		if(cur.visiting) {
			return true;
		}

		if(cur.dependencies.isEmpty()) {
			order.add(cur.data);
			cur.visited = true;
			return false;
		}
		
		cur.visiting= true;
		for(Graph.Node dependency : cur.dependencies) {
			boolean containsCycle = getOrder(graph, dependency, order);
			if(containsCycle) {
				return true;
			}
		}

		cur.visited = true;
		cur.visiting = false;
		order.add(cur.data);

		return false;
	}

	public static void main(String args[]) {
		List<Integer> jobs = List.of(new Integer[]{1,2,3,4});
		
		List<List<Integer>> dependencies = List.of( List.of(new Integer[]{1,2}), List.of(new Integer[]{1,3}), List.of(new Integer[]{3,2}), List.of(new Integer[]{4,2}), List.of(new Integer[]{4,3}) ); 
		
		System.out.println(getOrder(jobs, dependencies));
	}
}
