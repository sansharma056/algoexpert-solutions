import java.util.Arrays;

class SmallestDifference {
	public static int[] getSmallestDifference(int array1[], int array2[]) {
		int diff = Integer.MAX_VALUE;
		int res[] = new int[2];

		Arrays.sort(array1);
		Arrays.sort(array2);
		
		int i = 0;
		int j = 0;

		while(i < array1.length && j < array2.length) {
			int num1 = array1[i];
			int num2 = array2[j];

			int newDiff = Math.abs(num1-num2);

			if(num1 < num2) {
				i++;
			}
			else if(num1 > num2) {
				j++;
			} else {
				return new int[]{num1, num2};
			}
			
			if(newDiff < diff) {
				diff = newDiff;

				res[0] = num1;
				res[1] = num2;
			}
		}
		
		return res;
	}
	public static void main(String args[]) {
		int array1[] = new int[]{-1,5,10,20,28,3};
		int array2[] = new int[]{26,134,135,15,17};
		
		int res[] = getSmallestDifference(array1, array2);

		System.out.println(String.format("%d %d", res[0], res[1]));

	}
}
