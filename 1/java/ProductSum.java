import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ProductSum {
	
	public static int getProductSum(List<Object> array, int depth) {
		int sum = 0;	
		for(int i=0; i<array.size(); i++) {
			if(array.get(i) instanceof Integer) {
				sum = sum + ((int)array.get(i));
			} else {
				List<Object> subArray = (List<Object>)array.get(i);
				sum += getProductSum(subArray, depth+1);
			}
			System.out.println(sum);
		}
		return sum*depth;
	}
	
	public static void main(String args[]) {
		List<Object> array = new ArrayList<Object>();
		
		array = Arrays.asList(5,2, new ArrayList<Object>(Arrays.asList(7,-1)), 3, new ArrayList<Object>(Arrays.asList(6, new ArrayList<Object>(Arrays.asList(-13, 8)), 4)));
		
		System.out.println(array.toString());
		System.out.println(getProductSum(array, 1));
	}
}
