import java.util.HashMap;

class Fibonacci {
	
	public static long getFib(int n) {
		if(n == 2) {
			return 1;
		} else if(n==1) {
			return 0;
		}
		
		return getFib(n-1) + getFib(n-2);		
	}
	
	public static long getFibItr(int n) {
		long res[] = {0L, 1L};
		if(n == 0 || n == 1) {
			return res[n];
		}

		int i = 1;
		while(i <= n) {
			long nextFib = res[0] + res[1];
			res[0] =  res[1];	
			res[1] = nextFib;

			i++;
		}
		
		return res[1];
	}

	public static long getFib(int n, HashMap<Integer, Long> memoize) {
		if(memoize.get(n) != null) {
			return memoize.get(n);
		}
		
		memoize.put(n, getFib(n-1, memoize)+ getFib(n-2, memoize));

		return memoize.get(n);

	}
	

	public static void main(String args[]) {
		HashMap<Integer, Long> memoize = new HashMap<Integer, Long>();
		
		memoize.put(0, 0L);
		memoize.put(1, 1L);
		System.out.println(getFib(55, memoize));
	}

}
