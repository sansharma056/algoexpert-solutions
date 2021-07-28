import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

class RiverSizes {

	public static List<Integer> getRiverSizes(int matrix[][]) {
		List<Integer> riverSizes = new ArrayList<Integer>();	
		Map<Pair, Boolean> visited = new HashMap<Pair, Boolean>();	
		
		int r = matrix.length;
		int c = matrix[0].length;

		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				Pair pair = new Pair(i,j);
				
				if(visited.get(pair) == null) {
					if(matrix[i][j] == 1) {
						int riverSize = 0;
						Queue<Pair> q = new LinkedList<Pair>();
						q.add(pair);	

						while(!q.isEmpty()) {
							Pair cur = q.remove();

							if((cur.x >= 0 && cur.x < r) && (cur.y >= 0 && cur.y < c)) {
								if(visited.get(cur) == null && matrix[cur.x][cur.y] == 1) {
									riverSize++;
									q.add(new Pair(cur.x-1, cur.y));
									q.add(new Pair(cur.x+1, cur.y));
									q.add(new Pair(cur.x, cur.y-1));
									q.add(new Pair(cur.x, cur.y+1));
								}
								visited.put(cur, true);
							}
						}

						if(riverSize != 0) {
							riverSizes.add(riverSize);	
						}
					} else {
						visited.put(pair, true);
					}

				} 
			}
		}

		return riverSizes; 
	}

	public static void main(String args[]) {
		int matrix[][] = { {1,0,0,1,0}, {1,0,1,0,0}, {0,0,1,0,1}, {1,0,1,0,1}, {1,0,1,1,0} }; 
		

		List<Integer> riverSizes = getRiverSizes(matrix);
		
		System.out.println(riverSizes.toString());
	}

	// Helper class
	static class Pair {
		int x,y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(this.x, this.y);
		}

		@Override
		public boolean equals(Object o) {
			if(o == this) {
				return true;
			}

			if(!(o instanceof Pair)) {
				return false;
			}
			
			Pair pair = (Pair)o;
			
			return pair.x == this.x && pair.y == this.y; 
		}
	}
}
