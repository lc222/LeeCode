package Array;

/**
 * Created by liuchong on 2017/5/3.
 */
public class findPoisonedDuration {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int sum = 0;
        if(timeSeries.length<=0)
            return sum;
        for(int i=1; i<timeSeries.length; i++){
            if(timeSeries[i] - timeSeries[i-1] >= duration)
                sum += duration;
            else{
                sum +=timeSeries[i] - timeSeries[i-1];
            }
        }
        return sum+duration;
    }
}
