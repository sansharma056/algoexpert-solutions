import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Permutations {

	public static List<List<Integer>> getPermutations(Integer arr[]) {
		List<List<Integer>> res = new ArrayList<>();
		getPermutationsHelper(0, arr, res);
		return res;
	}

	public static void getPermutationsHelper(int i, Integer arr[], List<List<Integer>> res) {
		if(i == arr.length - 1) {
			res.add(List.of(arr.clone()));
			return;
		}

		for(int j=i; j<arr.length; j++) {
			swap(i, j, arr);
			getPermutationsHelper(i+1, arr, res);
			swap(i, j, arr);
		}
	}

	public static void swap(int i, int j, Integer arr[]) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String args[]) {
		Integer arr[] = {1,2,3};
		System.out.println(getPermutations(arr));
	}
}
