//352. Data Stream as Disjoint Intervals
/*
Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far as a list of disjoint intervals.

For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:

[1, 1]
[1, 1], [3, 3]
[1, 1], [3, 3], [7, 7]
[1, 3], [7, 7]
[1, 3], [6, 7]
Follow up:
What if there are lots of merges and the number of disjoint intervals are small compared to the data stream's size?

思路： 用TreeMap<Integer,Integer> 存储Interval
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class SummaryRanges {
    TreeMap<Integer, Integer> map;
    /** Initialize your data structure here. */
    public SummaryRanges() {
        map = new TreeMap();
    }
    
    public void addNum(int val) {
        Integer pre = map.floorKey(val);
        Integer next = map.ceilingKey(val);
        if(pre != null) {
            int before = map.get(pre);
            if(before >= val) {
                return;
            }
            if(before == val - 1) {
                if(next != null && next == val + 1) {
                    map.put(pre, map.get(next));
                    map.remove(next);
                } else {
                    map.put(pre, val);
                }
                return;
            }
        }
        if(next != null) {
            if(next == val) {
                return;
            }
            if(next == val + 1) {
                map.put(val, map.get(next));
                map.remove(next);
            } else {
                map.put(val, val);
            }
        } else {
            map.put(val, val);
        }
    }
    
    public List<Interval> getIntervals() {
        List<Interval> res = new ArrayList();
        for(int key: map.keySet()) {
            res.add(new Interval(key, map.get(key)));
        }
        return res;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */
