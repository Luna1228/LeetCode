/**
 * created by Luna1228
 * 1. Two Sum
 * Question description: https://leetcode.com/problems/two-sum/description/
 */
 
 class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hash = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            if(hash.containsKey(target - nums[i])) {
                return new int[]{hash.get(target-nums[i]), i};
            }
            hash.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
