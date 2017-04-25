package Array;

/**
 * Created by liuchong on 2017/4/25.
 */
public class minPathSum {
    public int minPathSum(int[][] grid) {
        for(int i=0; i<grid[0].length; i++)
            for(int j=0; j<grid.length; j++){
                if(i == 0 && j != 0)
                    grid[j][i] += grid[j-1][i];
                else if(j == 0 && i != 0)
                    grid[j][i] += grid[j][i-1];
                else
                    grid[j][i] += Math.min(grid[j-1][i], grid[j][i-1]);
            }
        return grid[grid.length-1][grid[0].length-1];
    }

    public int minPathSum1(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        return minPathSumHelper(grid, 0, 0, memo);
    }

    public int minPathSumHelper(int[][] grid, int row, int col, int[][] memo) {
        if(row == grid.length-1 && col == grid[0].length-1) return grid[row][col];
        if(memo[row][col] != 0) return memo[row][col];

        int rowInc = Integer.MAX_VALUE, colInc = Integer.MAX_VALUE;
        if(row < grid.length-1) rowInc = minPathSumHelper(grid, row+1, col, memo);
        if(col < grid[0].length-1) colInc = minPathSumHelper(grid, row, col+1, memo);
        memo[row][col] = Math.min(rowInc, colInc) + grid[row][col];
        return memo[row][col];
    }
}
