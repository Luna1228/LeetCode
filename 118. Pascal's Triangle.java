/**
 * created by Luna1228
 * Description: https://leetcode.com/problems/pascals-triangle/description/
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList();
        if(numRows == 0) return res;
        List<Integer> row = new ArrayList();
        row.add(1);
        res.add(row);
        for(int i = 2; i <= numRows; i++) {
            List<Integer> cur = new ArrayList();
            cur.add(1);
            List<Integer> last = res.get(res.size()-1);
            for(int j = 1; j < last.size(); j++) {
                cur.add(last.get(j-1) + last.get(j));
            }
            cur.add(1);
            res.add(cur);
        }
        return res;
    }
}
