/**
 * created by Luna1228
 * 220. Contains Duplicate III
 * Question description: https://leetcode.com/problems/contains-duplicate-iii/description/
 * BST
 */
 
 class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeMap<Long, Integer> map = new TreeMap();
        for(int i = 0; i < nums.length; i++) {
            Long low = map.floorKey((long)nums[i]);
            while(low != null && nums[i] - low <= t)  {
                if(i - map.get(low) <= k) {
                    return true;
                }
                low = map.lowerKey(low);
            }
            Long high = map.higherKey((long)nums[i]);
            while(high != null && high - nums[i] <= t) {
                if(i - map.get(high) <= k) {
                    return true;
                }
                high = map.higherKey(high);
            }
            map.put((long)nums[i], i);
        }
        return false;
    }
}
 
