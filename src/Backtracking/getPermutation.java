package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 60. Permutation Sequence

 The set [1,2,3,…,n] contains a total of n! unique permutations.

 By listing and labeling all of the permutations in order,
 We get the following sequence (ie, for n = 3):

 "123"
 "132"
 "213"
 "231"
 "312"
 "321"


 Given n and k, return the kth permutation sequence.

 Note: Given n will be between 1 and 9 inclusive.
 */

public class getPermutation {
    //Iterative:

    public String getPermutation(int n, int k) {

        // e.g n = 5
        // [1][1][2][6][24]
        int[] factorial = new int[n];
        factorial[0] = 1;

        for(int i = 1; i < n; i++) {
            factorial[i] = factorial[i-1] * i;
        }

        ArrayList<Integer> numbers = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        String res = "";
        for(int i = n-1; i >= 0; i--) {

            int num = (k-1)/factorial[i];
            res += numbers.get(num);
            k -= num * factorial[i];
            numbers.remove(num);
        }

        return res;
    }
    //Recursive:

    public String getPermutation1(int n, int k) {

        // recursive
        // how do you make the problem smaller?
        List<Integer> list = new ArrayList<>();
        // 1,1,2,6
        int[] factorials = new int[n];
        factorials[0] = 1;
        for(int i = 1; i < n; i++) {
            factorials[i] = factorials[i-1] * i;
        }

        for(int i = 1; i <= n; i++) {
            list.add(i);
        }

        return helper(list, k, factorials);
    }

    private String helper(List<Integer> list, int k, int[] factorials) {

        if(list.size() == 0) {
            return "";
        }

        int num = (k-1)/factorials[list.size()-1];
        String str = "" + list.get(num);
        k -= num * factorials[list.size()-1];
        list.remove(num);

        return str+helper(list, k, factorials);
    }
}
