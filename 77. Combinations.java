/**
 * created by Luna1228
 * backtracking
 */
 
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList();
        helper(res, new ArrayList(), 1, n, k);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> cur, int start, int n, int k) {
        if(k == 0) {
            res.add(new ArrayList(cur));
            return;
        }
        for(int i = start; i <= n-k+1; i++) {
            cur.add(i);
            helper(res, cur, i+1, n, k-1);
            cur.remove(cur.size()-1);
        }
    }
}
