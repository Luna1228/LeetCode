/**
 * created by Luna1228
 * 363. Max Sum of Rectangle No Larger Than K
 * Question Description: https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/description/
 * 1) brute force O(m^2n^2) (dp)
 * 2) optimize O(m^2nlogn) (TreeSet + dp)
 */
 
 class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int res = Integer.MIN_VALUE;
        //int m = matrix.length;
        //int n = matrix[0].length;
        /* 1: brute force: O(m^2n^2)
        int[][] dp = new int[m+1][n+1];

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + matrix[i-1][j-1];
            }
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                for(int x = i; x < m; x++) {
                    for(int y = j; y < n; y++) {
                        int sum = dp[x+1][y+1] + dp[i][j] - dp[i][y+1] - dp[x+1][j];
                        if(sum == k) return k;
                        if(sum < k)
                            res = Math.max(res, sum);
                    }
                }
            }
        }
        */
        
        //2.O(m^2nlogn)
        int m = matrix.length;
        int n = matrix[0].length;
        boolean rotate = false;
        if(m > n) {
            rotate = true;
            m = m - n;
            n = n + m;
            m = n - m;
        }
        for(int i = 0; i < m; i++) {
            int[] sum = new int[n];
            for(int j = i; j < m; j++) {
                for(int t = 0; t < n; t++) {
                    sum[t] += rotate? matrix[t][j]: matrix[j][t];
                }
                res = Math.max(res, getSum(sum, k));
                if(res == k) return k;
            }
        }
        
        return res;
    }
    
    //1D array to get the sum no larger than k
    public int getSum(int[] nums, int k) {
        int res = Integer.MIN_VALUE;
        if(nums.length == 0) return 0;
        //Set<Integer> set = new HashSet();
        TreeSet<Integer> set = new TreeSet();
        set.add(0);
        int curSum = 0;
        for(int num: nums) {
            curSum += num;
            /*for(int s: set) {
                if(curSum - s > res && curSum - s <= k) {
                    res = curSum-s;
                    if(res == k) return k;
                }
            }*/
            Integer val = set.ceiling(curSum - k);
            if(val != null) {
                res = Math.max(res, curSum - val);
                if(res == k) return k;
            }
            set.add(curSum);
        }
        return res;
    }
}
