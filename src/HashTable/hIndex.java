package HashTable;

import java.util.Arrays;

public class hIndex {
	public static int hIndex(int[] citations) {
	    int n = citations.length, tot=0;
	    int[] arr = new int[n+1];
	    for (int i=0; i<n; i++) {
	        if (citations[i]>=n) arr[n]++;
	        else arr[citations[i]]++;
	    }
	    for (int i=n; i>=0; i--) {
	        tot += arr[i];
	        if (tot>=i) return i;
	    }
	    return 0;
	}
	
	public int hIndex1(int[] citations) {
        if (citations == null || citations.length == 0) return 0;
        Arrays.sort(citations);
        int len = citations.length;
        for (int i = 0; i < citations.length; i++) {
            if (len <= citations[i])
                return len;
            else
                len--;
        }
        return len;
    }
	
	//��������
	public int hIndex2(int[] citations) {
	    Arrays.sort(citations);

	    int n = citations.length;
	    int i = 0, j = n - 1;

	    while (i <= j) {
	        int k = (i + j) / 2;
	        int v = citations[k];
	        int h = n - k;
	        if (v >= h) {
	            j = k - 1;
	        } else {
	            i = k + 1;
	        }
	    }

	    return n - j - 1;
	}
	
	public static void main(String[] args) {
		int [] tmp = {3, 0, 6, 1, 5}; 
		int res = hIndex(tmp);
		
	}
}
