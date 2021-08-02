import java.util.*;

class MinNumberOfJumps {
	
	//O(n^2)
	/*
	public static int minNumberOfJumps(int arr[]) {
		int hops[] = new int[arr.length];
		Arrays.fill(hops, Integer.MAX_VALUE);	
		hops[0] = 0;

		for(int i=1; i<arr.length; i++) {
			for(int j=0; j<i; j++) {
				if(i <= arr[j] + j) {
					hops[i] = Math.min(hops[j] + 1, hops[i]);
				}

			}
		}	

		return hops[hops.length-1];
	}	
	*/
	
	public static int minNumberOfJumps(int arr[]) {
		int jumps = 0;

		int maxReach = arr[0];
		int steps = arr[0];
		
		for(int i=1; i<arr.length-1; i++) {
			steps--;	
			maxReach = Math.max(maxReach, arr[i] + i);
			if(steps == 0) {
				jumps++;
				steps = maxReach-i;
			}

		}


		return jumps+1;
	}

	public static void main(String args[]) {
		int arr[] = {3,4,2,1,2,3,7,1,1,1,3};
		//int arr[] = {1,3,5,8,9,2,6,7,6,8,9};
		//int arr[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		System.out.println(minNumberOfJumps(arr));
	}
}
