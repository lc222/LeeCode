package BinarySearch;

/*

174. Dungeon Game

The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon

consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room

and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to

0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms;

other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.


Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal

path RIGHT-> RIGHT -> DOWN -> DOWN.

-2(K)	-3	3
-5	-10	1
10	30	-5(P)

Notes:

The knight's health has no upper bound.

Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right

room where the princess is imprisoned.

 */


public class calculateMinimumHP {

    public int calculateMinimumHP(int[][] dungeon) {
        int min = dungeon[0][0];
        for(int i=0; i<dungeon.length; i++){
            for(int j=0; j<dungeon[0].length; j++){
                if(i == 0 && j > 0) {
                    dungeon[i][j] += dungeon[i][j - 1];
                    min = Math.min(min, dungeon[i][j]);
                }
                if(i > 0 && j == 0) {
                    dungeon[i][j] += dungeon[i - 1][j];
                    min = Math.min(min, dungeon[i][j]);
                }
                if(i >0 && j > 0) {
                    dungeon[i][j] += Math.min(dungeon[i - 1][j], dungeon[i][j - 1]);
                    min = Math.min(min, dungeon[i][j]);
                }
            }
        }
        return min < 0 ? Math.abs(min) + 1 : 1;
    }

    public int calculateMinimumHP1(int[][] dungeon) {
        if(dungeon == null || dungeon.length == 0 || dungeon[0].length == 0){//[],[[]]
            return 0;
        }
        int[][] flag = new int[dungeon.length][dungeon[0].length];
        return dfs(dungeon, flag, 0, 0);
    }

    private int dfs(int[][] dungeon, int[][] flag, int x, int y){
        if(flag[x][y] != 0){
            return flag[x][y];
        }
        if(x == dungeon.length - 1 && y == dungeon[0].length - 1){//The down-right corner
            flag[x][y] = dungeon[x][y] < 0 ? -dungeon[x][y] + 1 : 1; //The minimum is 1
            return flag[x][y];
        }
        int min = Integer.MAX_VALUE;
        //go down
        if(x < dungeon.length - 1){
            int down = dfs(dungeon, flag, x + 1, y);
            min = min < down ? min : down;
        }
        //go right
        if(y < dungeon[0].length - 1){
            int right = dfs(dungeon, flag, x, y + 1);
            min = min < right ? min : right;
        }
        if(dungeon[x][y] >= min){//If min is 6, dungeon[x][y] if 10, then min should be updated to 1
            min = 1;
        }else{//If min is 6, dungeon[x][y] is 3 or -3, then min should be updated to 3 or 9
            min = min - dungeon[x][y];
        }
        flag[x][y] = min;
        return min;
    }

    public int calculateMinimumHP2(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;

        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] health = new int[m][n];

        health[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1);

        for (int i = m - 2; i >= 0; i--) {
            health[i][n - 1] = Math.max(health[i + 1][n - 1] - dungeon[i][n - 1], 1);
        }

        for (int j = n - 2; j >= 0; j--) {
            health[m - 1][j] = Math.max(health[m - 1][j + 1] - dungeon[m - 1][j], 1);
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int down = Math.max(health[i + 1][j] - dungeon[i][j], 1);
                int right = Math.max(health[i][j + 1] - dungeon[i][j], 1);
                health[i][j] = Math.min(right, down);
            }
        }

        return health[0][0];
    }
}
