package DFS_xunlian;

public class sixFillNumber {
	static int N = 14;
    static int[] a = new int[N];
    static boolean[] vis = new boolean[N];
    public static void main(String[] args) {
        a[1] = 1;
        vis[1] = true;

        a[2] = 8;
        vis[8] = true;

        a[12] = 3;
        vis[3] = true;

        dfs(1);
    }

    // a是最长数组，k是子数组的first index
    private static void dfs(int x){
        if(x==1||x==2||x==12){
            dfs(x+1);
            return;
        }

        if(x>12){
            int t[] = new int[6];
            t[0] = a[1] + a[3] + a[6] + a[8];
            t[1] = a[1] + a[4] + a[7] + a[11];
            t[2] = a[2] + a[3] + a[4] + a[5];
            t[3] = a[2] + a[6] + a[9] + a[12];
            t[4] = a[8] + a[9] + a[10] + a[11];
            t[5] = a[12] + a[10] + a[7] + a[5];

            for(int i = 1; i< t.length; i++){
                if (t[i]!=t[i-1]) return;
            }

            System.out.println("*="+a[6]);
            return;
        }

        for(int i = 1; i<13; i++){
            if(!vis[i]){
                vis[i]=true;
                a[x] = i;
                dfs(x+1);
                vis[i]=false;
            }
        }
    }
}
