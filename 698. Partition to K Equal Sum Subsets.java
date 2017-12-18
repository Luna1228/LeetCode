/**
 * created by Luna1228
 * 698. Partition to K Equal Sum Subsets
 * question description: https://leetcode.com/problems/partition-to-k-equal-sum-subsets/description/
 * recursion
 */
 
 class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        int n = nums.length;
        for(int num: nums) {
            sum += num;
        }
        if(sum % k != 0) return false;
        sum /= k;
        Arrays.sort(nums);
        int beginIndex = n-1;
        if(nums[beginIndex] > sum) {
            return false;
        }
        while(beginIndex >= 0 && nums[beginIndex] == sum) {
            k--;
            beginIndex--;
        }
        
        return partition(new int[k], nums, beginIndex, sum);
    }
    
    //try every element to add into every subset
    public boolean partition(int[] subset, int[] nums, int index, int target) {
        if(index < 0) {
            return true;
        }
        for(int i = 0; i < subset.length; i++) {
            if(subset[i] + nums[index] <= target) {
                subset[i] += nums[index];
                if(partition(subset, nums, index-1, target)) {
                    return true;
                }
                subset[i] -= nums[index];
            }
        }
        return false;
    }
}
