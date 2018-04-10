package MSRA_100;

import java.util.ArrayList;

public class T020_findCombination {
    public void findCombination(int n,int m,int flagI[]){
        if (n<1||m<1) {
            return;
        }
        if (n>m) {
            n=m;
        }
        if (n==m) {
            flagI[n-1]=1;
            for (int i = 0; i < flagI.length; i++) {
                if (flagI[i]==1) {
                    System.out.print(i+1+" ");
                }

            }
            System.out.println();
            flagI[n-1]=0;
        }

        flagI[n-1]=1;
        findCombination(n-1, m-n, flagI);

        flagI[n-1]=0;
        findCombination(n-1, m, flagI);
    }
}
