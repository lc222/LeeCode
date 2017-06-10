package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuchong on 2017/6/9.
 */
public class insert {

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    //53.6%
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        int i = 0;
        // add all the intervals ending before newInterval starts
        while (i < intervals.size() && intervals.get(i).end < newInterval.start)
            result.add(intervals.get(i++));
        // merge all overlapping intervals to one considering newInterval
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval = new Interval( // we could mutate newInterval here also
                    Math.min(newInterval.start, intervals.get(i).start),
                    Math.max(newInterval.end, intervals.get(i).end));
            i++;
        }
        result.add(newInterval); // add the union of intervals we got
        // add all the rest
        while (i < intervals.size()) result.add(intervals.get(i++));
        return result;
    }

    public List<Interval> insert1(List<Interval> intervals, Interval newInterval) {
        /**
         * Since the original list is sorted and all intervals are disjoint,
         * apply binary search to find the insertion index for the new
         * interval. [LC35]
         *
         * 1. Find insIdx=the insertion index of new.start, i.e., the first
         * index i such that list.get(i).start>=new.start.
         *
         * 2. Find nxtIdx=the insertion index of new.end, i.e., the first
         * index i such that list.get(i).end>=new.end.
         *
         * 3. Remove all elements of the list with indices insIdx<=i<nxtIdx.
         *
         * 4. Merge new with list.get(insIdx-1) or list.get(nxtIdx) or both.
         */

        int n = intervals.size();
        if (n == 0) {
            intervals.add(newInterval);
            return intervals;
        }

        int low = 0, high = n - 1, mid = 0;
        int temp, target = newInterval.start;
        while (low <= high) {
            mid = (low + high) / 2;
            temp = intervals.get(mid).start;
            if (temp == target)
                break;
            if (temp < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        // insIdx = the index where new interval to be inserted
        int insIdx = (low <= high) ? mid : low;
        Interval pre = (insIdx == 0) ? null : intervals.get(insIdx - 1);
        // 0<=insIdx<=n, pre=[insIdx-1], pre.start<new.start

        low = insIdx;
        high = n - 1;
        target = newInterval.end;
        while (low <= high) {
            mid = (low + high) / 2;
            temp = intervals.get(mid).end;
            if (temp == target)
                break;
            if (temp < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        // nxtIdx= the next index after the inserted new interval
        int nxtIdx = (low <= high) ? mid : low;
        Interval nxt = (nxtIdx == n) ? null : intervals.get(nxtIdx);
        // insIdx<=nxtIdx<=n, nxt=[nxtIdx], nxt.end>=new.end

        // [0]...[insIdx-1] <--> [insIdx]...[nxtIdx-1][nxtIdx]...[n]
        intervals.subList(insIdx, nxtIdx).clear();

        // check whether newInterval can be merged with pre or nxt
        boolean isMerged = false, isMerged2 = false;
        if (insIdx > 0 && pre.end >= newInterval.start) {
            pre.end = Math.max(pre.end, newInterval.end);
            isMerged = true;
        }

        if (nxtIdx < n && newInterval.end >= nxt.start) {
            nxt.start = Math.min(nxt.start, newInterval.start);
            isMerged2 = isMerged;
            isMerged = true;
        }

        if (!isMerged) {
            intervals.add(insIdx, newInterval);
            return intervals;
        }

        // merged with pre or nxt or both, deal with the both case
        if (isMerged2 && pre.end >= nxt.start) {
            nxt.start = pre.start; // pre.start < new.start, nxt.start;
            intervals.remove(insIdx - 1); // remove pre
        }

        return intervals;
    }
}
