/**
 * created by Luna1228
 * 654. Maximum Binary Tree
 * Question Description: https://leetcode.com/problems/maximum-binary-tree/description/
 */
 
 /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length == 0) return null;
        return helper(nums, 0, nums.length-1);
    }
    
    public TreeNode helper(int[] nums, int start, int end) {
        if(start > end) {
            return null;
        }
        int max = nums[start];
        int index = start;
        for(int i = start+1; i <= end; i++) {
            if(nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = helper(nums, start, index-1);
        root.right = helper(nums, index+1, end);
        return root;
    }
}
