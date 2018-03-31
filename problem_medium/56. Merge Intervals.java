/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
         if (intervals == null || intervals.isEmpty())
            return new ArrayList<>();
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        List<Interval> r = new ArrayList<>();
        r.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            if (r.get(r.size() - 1).end < intervals.get(i).start)
                r.add(intervals.get(i));
            else {
                Interval t = new Interval();
                t.start = r.get(r.size() - 1).start;
                t.end = Math.max(r.get(r.size() - 1).end, intervals.get(i).end);
                r.set(r.size()-1,t);
            }
        }
        return r;
    }
}