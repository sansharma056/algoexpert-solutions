import java.util.ArrayList;

class LongestPeak {
	public static ArrayList<Integer> findPeaks(int arr[]) {
		ArrayList<Integer> peaks = new ArrayList<Integer>();
		
		for(int i=1; i<arr.length-1; i++) {
			if(arr[i-1] < arr[i]  && arr[i] > arr[i+1]) {
				peaks.add(i);
			}
		}
		
		return peaks;
	}
	
	public static int calculatePeak(int arr[], int peakIndex) {
		int size = 1;
		
		int i=peakIndex;
		while(i >= 1 && arr[i-1] < arr[i]) {
			i--;
			size++;
		}
		
		i=peakIndex;
		while(i <=arr.length-2 && arr[i+1] < arr[i]) {
			i++;
			size++;
		}
		
		return size;
	}

	public static int longestPeak(int arr[]) {
		ArrayList<Integer> peaks = findPeaks(arr);
		int maxPeak = Integer.MIN_VALUE;
		for(int i=0; i<peaks.size(); i++) {
			if(calculatePeak(arr, peaks.get(i)) > maxPeak) {
				maxPeak = calculatePeak(arr, peaks.get(i));
			}
		}	

		return maxPeak;
	}

	public static void main(String args[]) {
		int arr[] = {1,2,3,3,4,0,10,6,5,-1,-3,2,3};	

		System.out.println(longestPeak(arr));
	}
}
