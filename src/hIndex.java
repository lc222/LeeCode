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
	
	public static void main(String[] args) {
		int [] tmp = {3, 0, 6, 1, 5}; 
		int res = hIndex(tmp);
		
	}
}
