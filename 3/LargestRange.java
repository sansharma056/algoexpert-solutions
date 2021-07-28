import java.util.*;

class LargestRange {
	
	public static int longestConsecutive(int [] nums) {
		if(nums.length == 0) {
			return 0;
		}

		int longest = 1;

		Map<Integer, Boolean> present = new HashMap<>();
		
		for(int i : nums) {
			present.put(i, false);
		}
			
		for(int i : nums) {
			if( present.get(i) ) {
				continue;
			}

			int length = 1;	
		
			int j=i-1;
			while( present.containsKey(j) ) {
				present.put(j, true);
				length++;
				j--;
			}
			
			j=i+1;
			while( present.containsKey(j) ) {
				present.put(j, true);
				length++;
				j++;
			}

			if(length > longest) {
				longest = length;
			}
		}

		return longest;
	}
	
	public static void main(String args[]) {
		//int arr[] = {1,11,3,0,15,5,2,4,10,7,2,6};
		//int arr[] = {0,3,7,2,5,8,4,6,0,1};
		int arr[] = {0,0};
		System.out.println(longestConsecutive(arr));

	}
}
