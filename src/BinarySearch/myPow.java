package BinarySearch;

/*

题目：

Implement pow(x, n).

 */


public class myPow {
    public double pow(double x, int m) {
        double temp = x;
        if (m == 0)
            return 1;
        temp = pow(x, m / 2);
        if (m % 2 == 0)
            return temp * temp;
        else {
            if (m > 0)
                return x * temp * temp;
            else
                return (temp * temp) / x;
        }
    }
}
