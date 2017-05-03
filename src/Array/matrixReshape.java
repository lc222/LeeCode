package Array;

/**
 * Created by liuchong on 2017/5/3.
 */
public class matrixReshape {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if(r*c != nums.length*nums[0].length)
            return nums;
        int [][] res = new int[r][c];
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                int n = i*c + j + 1;
                if(n%nums[0].length == 0)
                    res[i][j] = nums[n/nums[0].length-1][nums[0].length-1];
                else
                    res[i][j] = nums[n/nums[0].length][n%nums[0].length-1];
            }
        }
        return res;
    }

    public int[][] matrixReshape1(int[][] nums, int r, int c) {
        if(r*c != nums.length*nums[0].length)
            return nums;
        int [][] res = new int[r][c];
        int a=nums.length, b=nums[0].length, count=0;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++, count++){
                if(count%b == 0)
                    res[i][j] = nums[count/b-1][b-1];
                else
                    res[i][j] = nums[count/b][count%b-1];
            }
        }
        return res;
    }

    public int[][] matrixReshape2(int[][] nums, int r, int c) {

        if(nums==null) return null;
        if(r*c!=nums.length*nums[0].length)return nums;
        if(r==nums.length)return nums;

        int[][] res= new int[r][c];
        int a=0;
        int b=0;
        for(int[] i:nums){
            for(int j:i)
            {
                res[a][b]=j;
                b++;
                if(b==c){
                    b=0;
                    a++;
                }
            }

        }
        return res;
    }
}
