package HashTable;

import java.util.Stack;

public class maximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
        	return 0;
        int rLen = matrix.length;
        int cLen = matrix[0].length;
        int [] h = new int[cLen+1];
        h[cLen] = 0;
    	int max = 0;
        
    	for(int i=0; i<rLen; i++){
    		Stack<Integer> stack = new Stack<>();
    		for(int j=0; j<cLen+1; j++){
    			if(j<cLen)
    				if(matrix[i][j] == '1')
    					h[j] += 1;
    				else
    					h[j] = 0;
    			
    			if(stack.isEmpty() || h[stack.peek()]<h[j])
    				stack.push(j);
    			else{
    				while(!stack.isEmpty() && h[j]<h[stack.peek()]){
    					int top = stack.pop();
    					int area = h[top] * (stack.isEmpty()?i:(i-stack.peek()-1));
    					if(area>max)
    						max = area;
    				}
    				stack.push(i);
    			}
    		}
    	}
    	
        return max;
    }
}
