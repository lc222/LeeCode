package HashTable;

public class largestRectangleArea {
    public static int largestRectangleArea(int[] heights) {
        int res = 0;
        for(int i=0; i<heights.length; i++){
        	int tmp = 0, j = i, k = i;
        	while(j>=0 && k < heights.length && heights[j] <= heights[i] && heights[k] <= heights[i]){
        		if(heights[j] <= heights[i])
        			j--;
        		if(heights[k] <= heights[i])
        			k++;
        	}
        	tmp = heights[i] * (k-j);
        	res = Math.max(res, tmp);
        }

        return res;
    }
    
    public static void main(String [] args){
    	int [] heights = {2,1,5,6,2,3};
    	int res = largestRectangleArea(heights);
    	System.out.println(res);
    }
}
