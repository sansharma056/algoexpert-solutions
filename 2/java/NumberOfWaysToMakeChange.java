class NumberOfWaysToMakeChange {
	public static int getNumOfWays(int n, int denomations[]) {
		int ways[] = new int[n+1];
		ways[0] = 1;
		
		for(int denomation : denomations) {
			for(int amount = denomation; amount <= n; amount++) {
				ways[amount] += ways[amount-denomation];
			}
		}

		return ways[n];
	}

	public static void main(String args[]) {
		int denomations[] = {20,10,5,1};
		int n = 20;
		System.out.println(getNumOfWays(n, denomations));
	}
}
