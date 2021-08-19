class WaterArea {
	
	public static int getWaterArea(int height[]) {
		int n = height.length;
		
		int leftMax[] = new int[n];
		for(int i=1; i<n; i++) {
			leftMax[i] = Math.max(height[i-1], leftMax[i-1]);
		}	

		int rightMax[] = new int[n];
		for(int i=n-2; i>=0; i--) {
			rightMax[i] = Math.max(height[i+1], rightMax[i+1]);
		}
		
		int waterArea = 0;
		for(int i=0; i<n; i++) {
			int minHeight = Math.min(leftMax[i], rightMax[i]);
			waterArea += height[i] < minHeight ? minHeight - height[i] : 0;	
		}
		
		return waterArea;
	}
	
	public static void main(String args[]) {
		int height[] = {0,8,0,0,5,0,0,10,0,0,1,1,0,3};
		
		System.out.println(getWaterArea(height));
	}
}
