package MSRA_100;

public class T003_maxSubArray {
    public int maxSubArray(int [] array){
        if(array == null || array.length == 0)
            return 0;
        int sum = array[0], max = array[0];
        for(int i=1; i<array.length; i++){
            if(sum <= 0)
                sum = array[i];
            else
                sum += array[i];
            if(sum > max)
                max = sum;
        }
        return max;
    }
}
