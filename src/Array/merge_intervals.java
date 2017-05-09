package Array;

import java.util.*;

/**
 * Created by liuchong on 2017/5/8.
 */
public class merge_intervals {

    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() <= 1)
            return intervals;
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start != o2.start)
                    return o1.start - o2.start;
                return o1.end - o2.end;
            }
        });
        Iterator<Interval> it = intervals.iterator();
        Interval tmp = it.next();
        while(it.hasNext()){
            Interval next = it.next();
            if(tmp.end <= next.start){
                tmp = next;
                continue;
            }else{
                tmp.end = Math.max(tmp.end, next.end);
                it.remove();
            }
        }
        return intervals;
    }

    public List<Interval> merge1(List<Interval> intervals) {
        // sort start&end
        int n = intervals.size();
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        // loop through
        List<Interval> res = new ArrayList<Interval>();
        for (int i = 0, j = 0; i < n; i++) { // j is start of interval.
            if (i == n - 1 || starts[i + 1] > ends[i]) {
                res.add(new Interval(starts[j], ends[i]));
                j = i + 1;
            }
        }
        return res;
    }
    public List<Interval> merge2(List<Interval> intervals) {
        int N = intervals.size();
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i, Interval j){
                return i.end - j.end;
            }
        });
        for(int i = N-1; i>0;i--){
            Interval inter1 = intervals.get(i-1);
            Interval inter2 = intervals.get(i);
            if(inter1.end >= inter2.start){
                inter1.start = Math.min(inter1.start, inter2.start);
                inter1.end = inter2.end; //inter1.end is always smaller than inter2.end because of the sort, so no need to use Math.max()
                intervals.remove(i);
            }
        }
        return intervals;
    }
    public static void main(String[] args){
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 4));
        intervals.add(new Interval(5, 6));
        merge(intervals);
    }
}
