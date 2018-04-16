package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 51. N-Queens

 The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

 Given an integer n, return all distinct solutions to the n-queens puzzle.

 Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a

 queen and an empty space respectively.

 For example,
 There exist two distinct solutions to the 4-queens puzzle:

 [
 [".Q..",  // Solution 1
 "...Q",
 "Q...",
 "..Q."],

 ["..Q.",  // Solution 2
 "Q...",
 "...Q",
 ".Q.."]
 ]
 */

public class solveNQueens {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        boolean [] flag = new boolean[n];
        help(res, new ArrayList<String>(), flag, 0, n, -2);
        return res;
    }

    public static void help(List<List<String>> res, List<String> path, boolean [] flag, int start, int n, int pre){
        if(start == n){
            res.add(new ArrayList<>(path));
        }else {
            for(int j=0; j<n; j++){
                if(!flag[j] && (j < pre-1 || j > pre+1)){
                    flag[j] = true;
                    path.add(createString(j, n));
                    help(res, path, flag, start+1, n, j);
                    path.remove(path.size()-1);
                    flag[j] = false;
                }
            }
        }
    }

    public static String createString(int i, int n){
        StringBuilder s = new StringBuilder();
        for(int j=0; j<n; j++){
            if(j == i)
                s.append("Q");
            else
                s.append(".");
        }
        return s.toString();
    }

    public static void main(String [] args){
        List<List<String>> res = solveNQueens(4);
        System.out.println(res.toString());
    }

    //99%
    public List<List<String>> solveNQueens1(int n) {
        boolean[]
                //ocp0 = new boolean[n], //whether there's a queen ocupying nth row, I don't need it
                ocp90 = new boolean[n], //whether there's a queen ocupying nth column
                ocp45 = new boolean[2 * n - 1], // mark 45 degree occupation
                ocp135 = new boolean[2 * n - 1]; // mark 135 degree occupation
        List<List<String>> ans = new ArrayList<>();
        char[][] map = new char[n][n];
        for (char[] tmp : map) Arrays.fill(tmp, '.'); //init

        solve(0, n, map, ans, ocp45, ocp90, ocp135);
        return ans;
    }

    private void solve(int depth, int n, char[][] map, List<List<String>> ans,
                       boolean[] ocp45, boolean[] ocp90, boolean[] ocp135) {
        if (depth == n) {
            addSolution(ans, map);
            return;
        }

        for (int j = 0; j < n; j++)
            if (!ocp90[j] && !ocp45[depth + j] && !ocp135[j - depth + n - 1]) {
                ocp90[j] = true;
                ocp45[depth + j] = true;
                ocp135[j - depth + n - 1] = true;
                map[depth][j] = 'Q';
                solve(depth + 1, n, map, ans, ocp45, ocp90, ocp135);
                ocp90[j] = false;
                ocp45[depth + j] = false;
                ocp135[j - depth + n - 1] = false;
                map[depth][j] = '.';
            }
    }

    private void addSolution(List<List<String>> ans, char[][] map) {
        List<String> cur = new ArrayList<String>();
        for (char[] i : map) cur.add(String.valueOf(i));
        ans.add(cur);
    }

    public List<List<String>> solveNQueens2(int n) {
        List<List<String>> list=new ArrayList<List<String>>();
        dfs(new int[n],0,n,list);
        return list;
    }
    public void dfs(int[] pos,int step,int n,List<List<String>> list) {
        if(step==n) {
            ArrayList<String> ls=printboard(pos,n);
            list.add(new ArrayList<String>(ls));
            return;
        }
        for(int i=0;i<n;i++) {
            pos[step]=i;
            if(isvalid(pos,step)) {
                dfs(pos,step+1,n,list);
            }
        }
    }
    public boolean isvalid(int[] pos, int step) {
        for(int i=0;i<step;i++) {
            if(pos[i]==pos[step]||(Math.abs(pos[i]-pos[step]))==(step-i)) return false;

        }
        return true;
    }
    public ArrayList<String> printboard(int[] pos,int n) {
        ArrayList<String> ls=new ArrayList<String>();
        for(int i=0;i<n;i++) {
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<n-1;j++) sb.append('.');
            sb.insert(pos[i],'Q');
            ls.add(sb.toString());

        }
        return ls;
    }
}
