import java.util.*;

class ZigzagTraverse {
	
	public static List<Integer> zigzagTraverse(int mat[][]) {
		int r = mat.length;
		int c = mat[0].length;

		List<Integer> res = new ArrayList<>();
			
		int i=0,j=0;
		
		while(i<r && j<c) {
			res.add(mat[i][j]);

			//down or right
			if(i+1 < r) {
				i++;
			} else {
					j++;
			}	

			//upward diagonal traversal
			while(i>= 0 && j<c) {
				res.add(mat[i][j]);
				i--;
				j++;
			}

			i++;
			j--;

			//right or down
			if(j+1 <c) {
				j++;
			} else {
					i++;
			}

			//downward diagonal traversal
			while(i+1<r && j-1>=0) {
				res.add(mat[i][j]);
				i++;
				j--;
			}	

		}

		return res;
	}

	public static void main(String args[]) {
		int mat[][] = {
			{1,3,4,10},
			{2,5,9,11},
			{6,8,12,15},
			{7,13,14,16}
		};
		
		/*int mat[][] = {
			{1,3,4,},
			{2,5,9,},
			{6,8,12}
		};
		*/
		/*
		int mat[][] = {
			{1,3},
			{2,5}
		};
		*/
		/*
		int mat[][] = {
			{1,3,4,10},
			{2,5,9,11}
		};
		*/
		System.out.println(zigzagTraverse(mat));
	}
}
