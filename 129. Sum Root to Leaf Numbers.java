/**
 * created by Luna1228
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        return helper(root, 0);
    }
    
    public int helper(TreeNode root, int cur) {
        if(root.left == null && root.right == null) {
            return 10 * cur + root.val;
        }
        int res = 0;
        if(root.left != null) {
            res += helper(root.left, 10 * cur + root.val);
        }
        if(root.right != null) {
            res += helper(root.right, 10 * cur + root.val);
        }
        return res;
    }
}
