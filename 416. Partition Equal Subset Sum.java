/**
 * created by Luna1228
 * 416. Partition Equal Subset Sum
 * description: https://leetcode.com/problems/partition-equal-subset-sum/description/
 * 0-1 背包问题
 */
 
 class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int max = 0;
        int n = nums.length;
        for(int num: nums) {
            sum += num;
            max = Math.max(num, max);
        }
        if(sum % 2 == 1) return false;
        sum /= 2;
        if(max > sum) return false;
        if(max == sum) return true;
        //return canHaveSum(nums, 0, sum);
        //0/1 backpack
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        for(int i = 0; i < n; i++) {
            for(int j = sum-nums[i]; j >= 0; j--) {
                if(dp[j]) {
                    if(j + nums[i] == sum) return true;
                    dp[j+nums[i]] = true;
                }
            }
        }
        return false;
    }
    
   /* TLE: too slow
   public boolean canHaveSum(int[] nums, int index, int sum) {
        if(sum == 0) {
            return true;
        }
        if(index == nums.length) {
            return false;
        }
        
        for(int i = index+1; i < nums.length; i++) {
            if(canHaveSum(nums, i, sum-nums[index])) {
                return true;
            }
        }
        return false;
    }*/
}
