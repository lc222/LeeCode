package BinarySearch;

/**
 * Created by liuchong on 2017/7/18.

 We are playing the Guess Game. The game is as follows:

 I pick a number from 1 to n. You have to guess which number I picked.

 Every time you guess wrong, I'll tell you whether the number is higher or lower.

 You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

 -1 : My number is lower
 1 : My number is higher
 0 : Congrats! You got it!
 Example:
 n = 10, I pick 6.

 Return 6.

 猜数字游戏==每猜一个数字都会提示猜到了或者裁小了，根据提示再进行猜。注意整数求和溢出问题即可
 */
public class guessNumber {
    public int guessNumber(int n) {
        int start=0, end=n, mid;
        while(start <= end){
            //下面这两种方法都是避免整数溢出的解决方法。若直接使用（end+start）/2会溢出
            mid = start + (end - start) / 2;
            //mid = (start & end) + ((start ^ end) >> 1);
            int res = 1;//guess(mid);
            if(res == 0)
                return mid;
            else if(res == -1){
                end = mid -1;
            }else
                start = mid +1;
        }
        return end;
    }
}
