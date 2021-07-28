import java.util.Arrays;

class MinNumberOfCoinsForChange {
	public static int getMinNumCoins(int denominations[], int n) {
		int coins[] = new int[n+1];
		Arrays.fill(coins, Integer.MAX_VALUE);
		coins[0] = 0;
			
		for(int denomination : denominations) {
			for(int amount = denomination; amount <= n; amount++) {
				if(coins[amount-denomination] == Integer.MAX_VALUE) {
					coins[amount] = Math.min(coins[amount-denomination], coins[amount]);
				} else {
						coins[amount] = Math.min(coins[amount-denomination]+1, coins[amount]);
				}
			}
		}
		
		return coins[n];
	}

	public static void main(String args[]) {
		int denominations[] = {1,5,6,9};
		int n = 11;

		System.out.println(getMinNumCoins(denominations, n));
	}
}
