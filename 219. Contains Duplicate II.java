/**
 * created by Luna1228
 * 219. Contains Duplicate II
 * Question description: https://leetcode.com/problems/contains-duplicate-ii/description/
 * Hashtable
 * O(n)
 */
 class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap(); //remember last index of nums[i]
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                if(i - map.get(nums[i]) <= k) return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
