import java.util.*;

class Powerset {
	/*	
	public static List<Object> getPowerset(List<Integer> set) {
		List<Object> powerset = new ArrayList<Object>();
	
		int selected = 0;

		while(selected <= Math.pow(2,set.size())-1)	{
			String binaryNumber = Integer.toBinaryString(selected); 
			List<Integer> subset = new ArrayList<Integer>();	

			for(int i=binaryNumber.length()-1; i>=0; i--) {
				if(binaryNumber.charAt(i) == '1') {
					subset.add(set.get(binaryNumber.length()-i-1));
				}
			}		
			powerset.add(subset);
			selected = selected + 1;
		}

		return powerset;
	}	
	*/
	
	public static List<List<Integer>> getPowerset(List<Integer> set) {
		List<List<Integer>> powerset = new ArrayList<>();	
		powerset.add(Arrays.asList(new Integer[]{}));
		
		for(Integer num : set) {
			int n = powerset.size();
			for(int i=0; i<n; i++) {
				List<Integer> subset = new ArrayList<>(powerset.get(i));
				subset.add(num);
				powerset.add(subset);
			}
		}	 


		return powerset;
	}

	public static void main(String args[]) {
		List<Integer> set = new ArrayList<>();
		set = Arrays.asList(new Integer[]{1,2,3});

		System.out.println(getPowerset(set));
	}
}
