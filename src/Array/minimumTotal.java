package Array;

import java.util.List;

/**
 * Created by liuchong on 2017/4/17.
 */
public class minimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int [] res = new int[row+1];

        for (int i=row-1; i>=0; i--){
            List<Integer> tmp = triangle.get(i);
            for(int j=0; j<tmp.size(); j++)
                res[j] = Math.min(res[j], res[j+1]) + tmp.get(j);
        }
        return res[0];
    }

    public int minimumTotal1(List<List<Integer>> triangle) {
        for(int i=triangle.size()-2; i>=0; i--)
            for(int j=0; j<=i; j++)
                triangle.get(i).set(j, triangle.get(i).get(j)+Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)));
        return triangle.get(0).get(0);
    }
}
