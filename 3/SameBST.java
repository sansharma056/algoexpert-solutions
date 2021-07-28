import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class SameBST {
	public static boolean isSameBST(List<Integer> arr1, List<Integer> arr2) {
		if(arr1.size() != arr2.size()) {
			return false;
		}

		if(arr1.size() == 0)	{
				return true;
		}

		if(arr1.get(0) != arr2.get(0)) {
			return false;
		} 		

		List<Integer> arr1SubTree = new ArrayList<>();	
		List<Integer> arr2SubTree = new ArrayList<>();
	
		for(int i=1; i<arr1.size(); i++) {
			if(arr1.get(i) < arr1.get(0)) {
				arr1SubTree.add(arr1.get(i));
			}	

			if(arr2.get(i) < arr1.get(0)) {
				arr2SubTree.add(arr2.get(i));
			}	
		}	
		
		boolean isLeftSubtreeSame = isSameBST(arr1SubTree, arr2SubTree);
		
		arr1SubTree.clear();
		arr2SubTree.clear();

		for(int i=1; i<arr1.size(); i++) {
			if(arr1.get(i) > arr1.get(0)) {
				arr1SubTree.add(arr1.get(i));
			}	

			if(arr2.get(i) > arr1.get(0)) {
				arr2SubTree.add(arr2.get(i));
			}	
		}	

		boolean isRightSubtreeSame = isSameBST(arr1SubTree, arr2SubTree);

		return isLeftSubtreeSame && isRightSubtreeSame;
	}

	public static void main(String args[]) {
		//Integer arr1[] = {10,15,8,12,94,81,5,2,11};
		//Integer arr2[] = {10,8,5,15,2,12,11,94,81};
		Integer arr1[] = {10,15,8,5};
		Integer arr2[] = {10,8,15,5};

		System.out.println(isSameBST(List.of(arr1), List.of(arr2)));
	}
}
