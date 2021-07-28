class FindThreeLargestNumbers {
	
	public static int[] getThreeLargestNumber(int array[]) {
		int largest[] = new int[3];
		largest[0] = largest[1] = largest[2] = Integer.MIN_VALUE;	
		
		for(int i : array) {
			if(i > largest[2]) {
				largest[0] = largest[1];
				largest[1] = largest[2];
				largest[2] = i;
			} else if(i > largest[1]) {
				largest[0] = largest[1];
				largest[1] = i;
			} else if(i > largest[0]) {
				largest[0] = i;
			}

		}
		
		return largest;
	}

	public static void main(String args[]) {
		int array[] = new int[]{141,1,17,-7,-17,-27,18,541,8,7,7};

		for(int i : getThreeLargestNumber(array)) {
			System.out.print(String.format("%d \t", i));
		}

		System.out.println();
	}
}
