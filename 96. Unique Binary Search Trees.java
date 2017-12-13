/** created by Luna1228
 *
 * 96. Unique Binary Search Trees
 *
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 *
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 *
 * 1         3     3      2      1
 *  \       /     /      / \      \
 *   3     2     1      1   3      2
 *  /     /       \                 \
 * 2     1         2                 3
 *
 * 思路：
 * n = 1: 1种情况 dp[1] = 1
 * n = 2: 2种情况 dp[2] = 2
 *        2     1     
 *       /       \   
 *      1         2
 * n = 3, 5 种情况 dp[3] = 5
 *
 * 1         3     3      2      1
 *  \       /     /      / \      \
 *   3     2     1      1   3      2
 *  /     /       \                 \
 * 2     1         2                 3
 *
 * 相当于：如果1为根：有 dp[2]种可能
 *        如果2为根：有 dp[1]*dp[1]种可能
 *        如果3为根：有 dp[2]种可能
 * dp[i] = sum of(dp[i-1-k]*dp[k])
 *
 * Time compexity: O(n^2)
 * Space complexity: O(n)
 *
 */
 
 class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = i-1; j >= 0; j--) {
                dp[i] += dp[j]*dp[i-1-j];
            }
        }
        return dp[n];
    }
}
