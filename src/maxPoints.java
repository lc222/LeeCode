import java.util.HashMap;
import java.util.Map;

public class maxPoints {
	
	static class Point {
	     int x;
	     int y;
	     Point() { x = 0; y = 0; }
	     Point(int a, int b) { x = a; y = b; }
	}
	 
	public int maxPoints(Point[] points) {
        if(points == null || points.length == 0) return 0;
        int max = 0;
        for(int i=0;i<points.length-1;i++){
            HashMap<Double, Integer> pointsOnLine = new HashMap<>();
            int samePoint = 0, localMax = 0;
            for(int j=i+1;j<points.length;j++){
                int x = points[j].x - points[i].x;
                int y = points[j].y - points[i].y;
                if(x == 0 && y== 0) {
                    samePoint++;
                    continue;
                }
                double ratio = findRatio(x,y);
                if(!pointsOnLine.containsKey(ratio))
                    pointsOnLine.put(ratio, 1);
                else pointsOnLine.put(ratio, pointsOnLine.get(ratio)+1);
                localMax = Math.max(localMax, pointsOnLine.get(ratio));
            }
            max = Math.max(max, localMax + samePoint);
        }
        return max+1;
    }
    private Double findRatio(int x, int y){
        if(y == 0) return Double.MAX_VALUE;
        else return (double)x/(double) y + 0.0;
    }
    
    public static void main(String[] args){
    	Point p0 = new Point(0, 0);
    	Point p1 = new Point(1, 1);
    	Point p2 = new Point(1, -1);
    	Point [] points = {p0, p1, p2};
    }
    
}
