import java.util.*;

class MinRewards {
	
	//works but for only distinct elements 
	//Time Coplextity : O(n)
	/*
	public static int getMinRewards(int arr[]) {
		int n = arr.length;
		int rewards[] = new int[n];	
		
		int minIdx = 0;
		
		for(int i=1; i<n; i++) {
			if(arr[i]  < arr[minIdx] ) {
				minIdx = i;
			}
		}
		
		rewards[minIdx] = 1;

		for(int i=minIdx-1; i>=0; i--) {
			getMinReward(arr, rewards, i);
		}
		
		for(int i=minIdx+1; i<n; i++) {
			getMinReward(arr, rewards, i);
		}

		int minRewards = 0;
		for(int i=0; i<n; i++) {
			//System.out.print(rewards[i] + " ");
			minRewards += rewards[i];
		}

		return minRewards;
	}	
	
	public static void getMinReward(int arr[], int rewards[], int idx) {
		if(idx == 0) {
			if(arr[idx] < arr[idx+1]) {
				rewards[idx] = 1;	
			} else {
					rewards[idx] = rewards[idx+1] + 1;
			}
		} else if(idx == arr.length-1) {
				if(arr[idx] <= arr[idx-1]) {
					rewards[idx] = 1; 
				}	else {
						rewards[idx] = rewards[idx-1] + 1;

				}
		} else {
			if(rewards[idx-1] != 0) {
				if(arr[idx] >= arr[idx-1]) {
					rewards[idx] = rewards[idx-1] + 1;
				} else {
						rewards[idx] = 1;
				}


			} else if(rewards[idx+1] != 0) {
					if(arr[idx] > arr[idx+1]) {
						rewards[idx] = rewards[idx+1] + 1;
					} else {
							rewards[idx] = 1;
					}
			}	

		}
	}
	*/
	
	public static int getMinRewards(int arr[]) {
		int n = arr.length;

		int rewards[] = new int[n];
		Arrays.fill(rewards, 1);		
		
		for(int i=1; i<n; i++) {
			if(arr[i] > arr[i-1]) {
				rewards[i] = rewards[i-1] + 1;
			}
		}
		
		for(int i=n-2; i>=0; i--) {
			if(arr[i] > arr[i+1]) {
				rewards[i] = Math.max(rewards[i], rewards[i+1]+1);
			}
		}

		int minRewards = 0;
		for(int i=0; i<n; i++) {
			minRewards += rewards[i];	
		}

		return minRewards;
	}
	

	public static void main(String args[]) {
		//int arr[] = {8,4,2,1,3,6,7,9,5};
		//int arr[] = {1,2,2};
		int arr[] = {1,2,87,87,87,2,1};
		System.out.println(getMinRewards(arr));
	}
}
