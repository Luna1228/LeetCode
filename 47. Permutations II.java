/**
 * created by Luna1228
 * permutation of array with duplicate element
 */
 
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums);
        boolean[] flag = new boolean[nums.length];
        helper(res, new ArrayList(), flag, nums);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> cur, boolean[] flag, int[] nums) {
        if(cur.size() == nums.length) {
            res.add(new ArrayList(cur));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(flag[i]) continue;
            if(i>0 && nums[i-1]==nums[i] && !flag[i-1]) continue;
            cur.add(nums[i]);
            flag[i] = true;
            helper(res, cur, flag, nums);
            flag[i] = false;
            cur.remove(cur.size()-1);
        }
    }
}
