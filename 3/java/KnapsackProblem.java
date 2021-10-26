import java.util.ArrayList;
import java.util.List;

class KnapsackProblem {
		
	public static List<int[]> backtrack(int values[][], int items[][]) {
		int i = values.length-1;
		int j =  values[0].length-1;

		List<int[]> res = new ArrayList<>();
		
		while(i>=1 && j>=1) {
			int curItem[] = items[i-1];

			if(values[i][j] != values[i-1][j]) {
				res.add(curItem);
				i = i-1;
				j = j-curItem[1];
			} else {
				i = i-1;
			}	
		}

		return res;
	}

	public static List<int[]> solveKnapsackProblem(int items[][], int maxWeight) {
		int values[][] = new int[items.length+1][maxWeight+1];
	
		for(int i=1; i<=items.length; i++) {
			for(int j=1; j<=maxWeight; j++) {
				int curItem[] = items[i-1]; 
				if(curItem[1] <= j) {
					values[i][j] = Math.max( values[i-1][j], values[i-1][j-curItem[1]] + curItem[0] );
				} else {
					values[i][j] = values[i-1][j];
				}
			}
		}
		
		List<int[]> res = backtrack(values, items);	

		return res;
	}

	public static void main(String args[]) {
		int items[][] = {{1,2}, {4,3}, {5,6}, {6,7}};
		int maxWeight = 10;
		
		List<int[]> res = solveKnapsackProblem(items, maxWeight);
		
		for(int[] pair : res) {
			System.out.println(String.format("Value: %d, Weight: %d", pair[0], pair[1]));
		}
	}
}
