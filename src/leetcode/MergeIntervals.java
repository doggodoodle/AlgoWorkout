package leetcode;

import java.util.*;

/**
 * Created on 2/3/19.
 * https://leetcode.com/problems/merge-intervals/
 */
public class MergeIntervals {
    public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) {
            return intervals;
        }
        List<Interval> res = new ArrayList<>();

        List<Integer> starts = new ArrayList<>();
        Map<Integer, List<Interval>> map = new HashMap<>();
        for (Interval in : intervals) {
            if (map.get(in.start) == null) {
                starts.add(in.start);
            }
            map.computeIfAbsent(in.start, v -> new ArrayList<>()).add(in);
        }
        Collections.sort(starts);

        List<Interval> sorted = new ArrayList<>();
        for (int i : starts) {
            sorted.addAll(map.get(i));
        }
        //System.out.println(sorted);
        int s = sorted.get(0).start, e = sorted.get(0).end;
        Interval iv = new Interval(sorted.get(0).start, sorted.get(0).end);
        res.add(iv);
        for (int i = 0; i < sorted.size(); i++) {
            if (sorted.get(i).start <= iv.end) {
                iv.end = Math.max(iv.end, sorted.get(i).end);
                continue;
            }
            iv = new Interval(sorted.get(i).start, sorted.get(i).end);
            res.add(iv);
        }
        return res;
    }
}
