import java.util.HashMap;
import java.util.Map;

public class numberOfBoomerangs {
    public static int numberOfBoomerangs(int[][] points) {
    	int res = 0;
    	int dis = 0;
        for(int i =0; i<points.length; i++){
        	Map<Integer, Integer> tmp = new HashMap<>();
        	for(int j=0; j<points.length; j++){
        		if(i==j)
        			continue;
        	    int a = 0;
        	    int b = 0;
        	    a = points[i][0]-points[j][0];
        	    b = points[i][1]-points[j][1];
        		dis = a*a + b*b;
        		if(tmp.containsKey(dis))
        			tmp.put(dis, tmp.get(dis)+1);
        		else
        			tmp.put(dis, 1);
        	}
        	for(int val : tmp.values()){
        		res += val*(val-1);
        	}
        }
        return res;
    }
    
    public int numberOfBoomerangs2(int[][] points) {
        int result = 0;
        HashMap<Integer,Integer> distMap = new HashMap<Integer,Integer>();
        for(int[] i : points) {
            for(int[] j : points) {
                if(i==j) continue;
                int dist = (i[0]-j[0])*(i[0]-j[0]) + (i[1]-j[1])*(i[1]-j[1]);
                int prevDist = distMap.containsKey(dist) ? distMap.get(dist) : 0;
                result += 2*prevDist;
                distMap.put(dist, prevDist+1);
            }
            distMap.clear();
        }
        return result;
    }
    
    //上面两种方法都是击败45%，下面这种方法击败了78%的用户，不知道为什么，明明思路都是一样的
    public int numberOfBoomerangs3(int[][] p) {
        int n = p.length;
        if(n==0) return 0;
        int count = 0;
        for(int i=0;i<n;i++){
            Map<Double,Integer> map = new HashMap<>();
            for(int j=0;j<n;j++){
                if(map.containsKey(distance(p[i],p[j]))){
                    int value = map.get(distance(p[i],p[j]));
                    count+=2*value;
                    map.put(distance(p[i],p[j]),value+1);
                } else {
                    map.put(distance(p[i],p[j]),1);
                }
            }
        }
        return count;
    }
    
    public Double distance(int[] a, int[]b){
        return Math.sqrt(Math.pow(a[0]-b[0],2) + Math.pow(a[1]-b[1],2));
    }
    
	public static void main(String[] args){
		int[][] nums = {{0,0}, {1,0}, {2,0}};
		int res = numberOfBoomerangs(nums);
		System.out.println(res);
	}
}
