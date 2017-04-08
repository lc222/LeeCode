package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuchong on 2017/4/7.
 */
public class getRow {
    //yang hui san jiao de n_th row
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);

        List<Integer> tmp = new ArrayList<>();
        for(int i=1; i<rowIndex; i++){
            res.clear();
            res.add(1);
            for(int j=0; j<tmp.size()-1; j++){
                res.add(tmp.get(j) + tmp.get(j+1));
            }
            res.add(1);
            tmp.clear();
            tmp.addAll(res);
        }
        return res;
    }

    public List<Integer> getRow1(int rowTndex){
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<rowTndex+1; i++){
            res.add(0, 1);
            for(int j=1; j<res.size(); j++)
                res.set(j, res.get(j) + res.get(j+1));
        }
        return res;
    }

    public static List<Integer> getRow2(int rowIndex) {
        List<Integer> list = new ArrayList<>(rowIndex + 1);
        if (rowIndex >= 0)
            list.add(1);
        for (int i = 1, num = 1; i <= rowIndex; i++) {
            num = (int) ((double) num / i * (rowIndex - i + 1) + 0.1);
            list.add(num);
        }
        return list;
    }

    public List<Integer> getRow3(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        int k = rowIndex;
        for( int i = 1; i <= rowIndex; i++, k-- ){
            // Using double to remove the overflow
            double tmp = ((double)res.get(i-1)*k)/i;
            res.add( (int)tmp );
        }
        return res;
    }
}
