import java.util.ArrayList;
import java.util.List;

class MaxSumIncreasingSubsequence {
	

	public static int getMaxSumIncrSubseq(int arr[]) {
		int n = arr.length;
		int sumIncrSubseq[] = arr.clone();
		int sequence[] = new int[n];
		sequence[0] = -1;

		int maxIdx = 0;

		for(int i=0; i<n; i++) {
			for(int j=0; j<i; j++) {
				if(arr[j] < arr[i] && sumIncrSubseq[j] + arr[i] >= sumIncrSubseq[i]) {
					sumIncrSubseq[i] = sumIncrSubseq[j] + arr[i];
					sequence[i] = j;
				}
			}
			if(sumIncrSubseq[i] > sumIncrSubseq[maxIdx]) {
				maxIdx = i;
			}
		}
		
		System.out.println(getSeq(arr, sequence, maxIdx));

		return sumIncrSubseq[maxIdx]; 
	}
	
	public static List<Integer> getSeq(int arr[], int sequence[], int maxIdx) {
		List<Integer> seq = new ArrayList<Integer>();
		seq.add(arr[maxIdx]);
		
		int cur = sequence[maxIdx];
		while(cur != -1) {
			seq.add(arr[cur]);
			cur = sequence[cur];
		}

		return seq;
	}

	public static void main(String args[]) {
		//int arr[] = {8,12,2,3,15,5,7};
		//int arr[] = {1,101,2,3,100,4,5};
		//int arr[] = {3,4,5,10};
		int arr[] = {10,5,4,3};
		System.out.println(getMaxSumIncrSubseq(arr));
	}
}
