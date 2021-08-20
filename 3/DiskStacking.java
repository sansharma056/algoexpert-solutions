import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class DiskStacking {
	
	public static boolean isStrictlyDec(int disk1[], int disk2[]) {
		return disk1[0] < disk2[0] && disk1[1] < disk2[1] && disk1[2] < disk2[2]; 
	}
	
	public static List<int[]> backtrack(int disks[][], int sequence[], int maxHeightIdx) {
		List<int[]> res = new ArrayList<>();
		
		while(maxHeightIdx != -1) {
			res.add(disks[maxHeightIdx]);
			maxHeightIdx = sequence[maxHeightIdx];
		}
		
		Collections.reverse(res);

		return res;
	}

	public static List<int[]> getStackedDisks(int disks[][]) {
		Arrays.sort(disks, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		
		int maxDimensions[] = new int[disks.length];
		for(int i=0; i<maxDimensions.length; i++) {
			maxDimensions[i] = disks[i][2];
		}
		
		int sequence[] = new int[disks.length];
		int maxHeightIdx = 0;
		Arrays.fill(sequence, -1);

		for(int i=1; i<disks.length; i++) {
			for(int j=0; j<i; j++) {
				if(isStrictlyDec(disks[j], disks[i])) {
					if(maxDimensions[i] <= disks[i][2] + maxDimensions[j]) {
						maxDimensions[i] = disks[i][2] + maxDimensions[j];
						sequence[i] = j;
					}
				}
			}

			if(maxDimensions[maxHeightIdx] <= maxDimensions[i]) {
				maxHeightIdx = i;
			}
		}
		
		return backtrack(disks, sequence, maxHeightIdx);
	}

	public static void main(String args[]) {
		int disks[][] = { {2,1,2}, {3,2,3}, {2,2,8}, {2,3,4}, {2,2,1}, {4,4,5} };
		
		for(int disk[] : getStackedDisks(disks)) {
			System.out.println(disk[0] + "," + disk[1] + "," + disk[2] );
		}
	}
}
