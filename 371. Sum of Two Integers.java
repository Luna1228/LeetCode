/**
 * created by Luna1228
 * 371. Sum of Two Integers
 * Question description: https://leetcode.com/problems/sum-of-two-integers/description/
 * bit manipulation
 */
 class Solution {
    public int getSum(int a, int b) {
        while(b != 0) {
            int sum = a ^ b;
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        }
        return a;
    }
}
 
