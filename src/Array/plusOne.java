package Array;

/**
 * Created by liuchong on 2017/4/9.
 */
public class plusOne {
    public int[] plusOne(int[] digits) {
        for(int j=digits.length-1; j>=0; j--){
            if(digits[j] != 9){
                digits[j] += 1;
                return digits;
            }else
                digits[j] = 0;
        }
        int [] res = new int[digits.length +1];
        res[0] = 1;
        return res;
    }
}
