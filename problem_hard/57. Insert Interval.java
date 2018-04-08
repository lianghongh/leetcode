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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        int end=0;
        for(int i=0;i<intervals.size();i++)
        {
            Interval t=intervals.get(i);
            if ((t.start<=newInterval.start&&t.end>=newInterval.start)||(newInterval.start<=t.start&&newInterval.end>=t.start))
            {
                newInterval=new Interval(Math.min(newInterval.start,t.start),Math.max(newInterval.end,t.end));
                end++;
            }
            else
                result.add(intervals.get(i));
        }
        result.add(newInterval);
        Collections.sort(result, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });
        return result;
    }
}