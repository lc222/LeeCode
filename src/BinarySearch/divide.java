package BinarySearch;
/*
29. Divide Two Integers

Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.

 */
public class divide {

    public int divide(int dividend, int divisor) {
        int sign = 1;
        if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            sign = -1;

        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);

        if(ldivisor == 0)
            return Integer.MAX_VALUE;
        if((ldividend == 0) || (ldivisor > ldividend))
            return 0;

        long lans = ldivide1(ldividend, ldivisor);

        int ans;
        if(lans > Integer.MAX_VALUE)
            ans = (sign == 1)? Integer.MAX_VALUE : Integer.MIN_VALUE;
        else
            ans = (int) (sign * lans);

        return ans;
    }

    public long ldivide(long ldividend, long ldivisor){
        if(ldividend < ldivisor)
            return 0;

        long sum = ldivisor;
        long multiple = 1;
        while(sum + sum <= ldividend){
            sum += sum;
            multiple += multiple;
        }
        return multiple + ldivide(ldividend - sum, ldivisor);
    }

    public long ldivide1(long ldividend, long ldivisor){
        if(ldivisor == 1)
            return ldividend;
        long res = 0;
        long tmp = ldivisor;
        while(tmp <= ldividend){
            tmp += ldivisor;
            res += 1;
        }
        return res;
    }

}
