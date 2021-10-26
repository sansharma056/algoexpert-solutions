import java.util.*;

class FourNumberSum {
	
	public static List<List<Integer>> getFourNumSum(int arr[], int target) {
		List<List<Integer>> res = new ArrayList<>();
	
		Map< Integer, List<List<Integer>> > allPairsSum = new HashMap<>();
		
		int n = arr.length;

		for(int i=1; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				int p = arr[i] + arr[j];

				int q = target - p;

				if(allPairsSum.containsKey(q)) {
					for(List<Integer> pair : allPairsSum.get(q)) {
						List<Integer> quadruplet = new ArrayList<>();	
						
						quadruplet.addAll(pair);
						quadruplet.add(arr[i]);
						quadruplet.add(arr[j]);

						res.add(quadruplet);
					}

				}
			}

			for(int k=0; k<i; k++) {
				int q = arr[k] + arr[i];
				List<Integer> pair = List.of(new Integer[]{arr[k], arr[i]});

				if(allPairsSum.containsKey(q)) {
					allPairsSum.get(q).add(pair);
				} else {
						List<List<Integer>> pairGroup = new ArrayList<>();
						pairGroup.add(pair);
						allPairsSum.put(q, pairGroup);
				}
			}

		}
		
		return res; 
	}

	public static void main(String args[]) {
		int arr[] = {7,6,4,-1,1,2};
		int target = 16;
		
		System.out.println(getFourNumSum(arr, target));
	}
}
