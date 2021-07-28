import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Permutations {
	
	public static List<List<Integer>> getPermutations(int arr[]) {
		boolean selected[] = new boolean[arr.length];
		List<Integer> permutation = new ArrayList<>();	
		List<List<Integer>> res = new ArrayList<>();

		getPermutation(arr, selected, permutation, res);

		return res;
	}
	
	public static void getPermutation(int arr[], boolean selected[], List<Integer> permutation, List<List<Integer>> res) {
		if(permutation.size() == arr.length) {
			res.add(new ArrayList<>(permutation));	
			return;
		}

		for(int i=0; i<arr.length; i++) {
			if(!selected[i]) {
				selected[i] = true;
				permutation.add(arr[i]);
				getPermutation(arr, selected, permutation, res);
				selected[i] = false;
				permutation.remove(permutation.size()-1);
			}
		}

	}

	public static void main(String args[]) {
		int arr[] = {1,2,3};
		System.out.println(getPermutations(arr));	
	}
}
