package Array;

/**
 * Created by liuchong on 2017/4/24.
 */
public class uniquePaths {
    public int uniquePaths(int m, int n) {
        int[] row = new int[m];
        for(int i=0; i<m; i++)
            row[i] = 1;
        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                row[j] = row[j-1] + row[j];
            }
        }
        return row[m-1];
    }

    public int uniquePaths1(int m, int n) {

        long result = 1;
        for(int i=0;i<Math.min(m-1,n-1);i++)
            result = result*(m+n-2-i)/(i+1);
        return (int)result;

    }
}
