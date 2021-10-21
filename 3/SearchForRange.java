import java.util.Arrays;
class SearchForRange {
	public static int solve(int arr[], int first, int last, int range[], int target) {
		if(first > last) {
			return -1;
		}

		int mid = (first+last) / 2;

		if(arr[mid] == target) {
			if( (mid-1 == -1 || arr[mid-1] != target) && (mid+1 == arr.length || arr[mid+1] != target)) {
				range[0] = range[1] = mid;
			} else if(mid-1 == -1 || arr[mid-1] != target) {
					range[0] = mid;
					solve(arr, mid+1, last, range, target );
			} else if(mid+1 == arr.length || arr[mid+1] != target) {
					range[1] = mid;
					solve(arr, first, mid-1, range, target);
			} else {
					solve(arr, first, mid-1, range, target);
					solve(arr, mid+1, last, range, target);
			}
			return mid;
		}	else if(target < arr[mid]) {
				return solve(arr, first, mid-1, range, target);
		} else {
				return solve(arr, mid+1, last, range, target);
		}

	}

	public static int[] solve(int arr[], int target) {
		int range[] = new int[2];

		int pos = solve(arr, 0, arr.length-1, range, target);
		if(pos == -1) {
			return new int[]{-1, -1};
		}

		return range;
	}


	public static void main(String args[]) {
		int arr[] = {0,1,21,33,45,45,45,45,45,45,61,71,73};
		int target = 45;

		System.out.println(Arrays.toString(solve(arr, target)));
	}
}
