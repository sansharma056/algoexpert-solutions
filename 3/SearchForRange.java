import java.util.Arrays;
class SearchForRange {
	public static void solve(int arr[], int first, int last, int range[], int target, boolean goLeft) {
		while(first <= last) {
			int mid = (first+last) / 2;

			if (target < arr[mid]) {
				last = mid -1;
			} else if (target > arr[mid]) {
				first = mid + 1;
			} else {
				if(goLeft) {
					if(mid == 0 || arr[mid-1] != arr[mid]) {
						range[0] = mid;
						return;
					}	else {
						last = mid - 1;
					}
				}	else {
					if(mid == arr.length-1 || arr[mid+1] != arr[mid]) {
						range[1] = mid;
						return;
					} else {
						first = mid + 1;
					}
				}
			}
		}
	}


	public static int[] solve(int arr[], int target) {
		int range[] = {-1,-1};

		solve(arr, 0, arr.length-1, range, target, true);
		solve(arr, 0, arr.length-1, range, target, false);

		return range;
	}


	public static void main(String args[]) {
		int arr[] = {0,1,21,33,45,45,45,45,45,45,61,71,73};
		int target = 45;

		System.out.println(Arrays.toString(solve(arr, target)));
	}
}
