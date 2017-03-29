package HashTable;

public class islandPerimeter {
	//�뵽�ĵ�һ������������37%�û�
    public static int islandPerimeter(int[][] grid) {
    	int lenth = 0;
        for(int i=0; i<grid.length; i++)
        	for(int j=0; j<grid[0].length; j++)
        	{
        		if(grid[i][j]==1)
        		{
        			if(i>0 && grid[i-1][j] == 0)
        				lenth += 1;
        			else if(i == 0)
        				lenth += 1;
        			if(j>0 && grid[i][j-1] == 0)
        				lenth += 1;
        			else if(j == 0)
        				lenth += 1;
        			if(i < grid.length-1 && grid[i+1][j] == 0)
        				lenth += 1;
        			else if(i == grid.length-1)
        				lenth += 1;
        			if(j < grid[0].length-1 && grid[i][j+1] == 0)
        				lenth += 1;
        			else if(j == grid[0].length-1)
        				lenth += 1;
        		}
        	}
        return lenth;
    }
	
    //�Ľ���һ�±ߵ�ͳ�Ʒ���������73%���û��������һ�ַ���ȥ�ж�ÿһ��island����Χ���
    //���ǿ��ǵ�������island���ڣ�����һ�������ߣ��Ҹñ�����½���ڲ�������Ӧ�ñ�������½���ܳ�֮�ڡ�
    //����ʹ��4*island - 2*neighbor���ɱ�ʾ½���ܳ���
    public static int islandPerimeter1(int[][] grid){
    	int islands = 0, neighbours = 0;
    	for(int i=0; i<grid.length; i++)
    		for(int j=0; j<grid[i].length; j++){
    			if(grid[i][j] == 1){
    				islands += 1;
    				if(i < grid.length-1 && grid[i+1][j] == 1) neighbours += 1;
    				if(j < grid[i].length-1 && grid[i][j+1] == 1) neighbours += 1;
    			}
    		}
    	return islands*4 - neighbours*2;
    }
    
    //���ַ���ʹ��������ȱ�����DFS���ķ�����ʱ�临�Ӷ�Ϊo(mn)��������95%���û�
    public static int islandPerimeter2(int[][] grid) {
        if (grid == null) return 0;
        for (int i = 0 ; i < grid.length ; i++){
            for (int j = 0 ; j < grid[0].length ; j++){
                if (grid[i][j] == 1) {
                    return getPerimeter(grid,i,j);
                }
            }
        }
        return 0;
    }
    
    public static int getPerimeter(int[][] grid, int i, int j){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {return 1;}
        if (grid[i][j] == 0) {
            return 1;
        }
        if (grid[i][j] == -1) return 0;
        
        int count = 0;
        grid[i][j] = -1;
        
        count += getPerimeter(grid, i-1, j);
        count += getPerimeter(grid, i, j-1);
        count += getPerimeter(grid, i, j+1);
        count += getPerimeter(grid, i+1, j);
        
        return count;
        
    }
    
    public static void main(String[] args){
		int [][] nums = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
		//int [][] nums = {{0,1}};
		int target = 7;
		int res = islandPerimeter2(nums);
		System.out.println(res);
		System.out.println(1/10);
	}
}
