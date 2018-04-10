package MSRA_100;

public class T019_fibonacci {
    public int fibonacci(int n){
        if(n <= 0)
            return 0;
        if(n == 1 || n == 2)
            return 1;
        int a=1, b=1, c=0;
        for(int i=3; i<=n; i++){
            c = a+b;
            b=a;
            a=c;
        }
        return c;
    }
}
