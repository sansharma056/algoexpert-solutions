import java.util.Arrays;
import java.util.ArrayList;

class ThreeNumSum {
	
	public static ArrayList<int[]> threeNumSum(int array[], int target) {
		ArrayList pairs = new ArrayList<int[]>();	

		Arrays.sort(array);
		int n = array.length;	
		
		for(int i=0; i<=n-3; i++) {
			int left_ptr = i+1;
			int right_ptr = n-1;
			
			while(left_ptr < right_ptr) {
				if(array[left_ptr] + array[right_ptr] + array[i] == target) {
					pairs.add(new int[]{array[i], array[left_ptr], array[right_ptr]});
					left_ptr++;
					right_ptr--;
				} else if(array[left_ptr] + array[right_ptr] + array[i] < target) {
						left_ptr++;	
				} else if(array[left_ptr] + array[right_ptr] + array[i] > target) {
						right_ptr--;
				}
			}

		}
		
		return pairs;
	}

	public static void main(String args[]) {
		int array[] = new int[]{12,3,1,2,-6,5,-8,6};
		int target = 0;

		ArrayList pairs = threeNumSum(array, target);

		for(int i=0; i<pairs.size(); i++) {
			int pair[] = (int[])pairs.get(i);
			for(int number : pair) {
				System.out.print(String.format("%d \t", number));
			}
			System.out.println();
		}
	}
}
