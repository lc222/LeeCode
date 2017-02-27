package DFS_xunlian;

public class MiGong {
	public static void main(String[] args) {
		int [][]maze = {
				{0, 1, 0, 0, 0},
				{0, 1, 0, 1, 0},
				{0, 0, 0, 0, 0},
				{0, 1, 1, 1, 0},
				{0, 0, 0, 1, 0}};
		  int [][] migong = {{0, 0, 0, 0, 0},
	      {0, 1, 1, 1, 0},
	      {0, 1, 0, 0, 0},
	      {0, 1, 1, 0, 1},
	      {0, 0, 0, 0, 0}};
		dfs(migong, 0, 0);
	}
	
	public static void dfs(int [][] migong, int i, int j){
		if(i<0 || j<0 || i>=5 || j>=5)
			return;
		if(migong[i][j] == 1)
			return;
		if(migong[i][j] == -1)
			return;
		
		if(migong[i][j] == 0)
			migong[i][j] = -1;
		
		dfs(migong, i-1, j);
		dfs(migong, i, j-1);
		dfs(migong, i+1, j);
		dfs(migong, i, j+1);
	}
}
