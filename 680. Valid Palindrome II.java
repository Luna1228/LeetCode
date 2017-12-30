/**
 * created by Luna1228
 * 680. Valid Palindrome II
 * Question Description: https://leetcode.com/problems/valid-palindrome-ii/description/
 * Two Point
 */
 
 class Solution {
    boolean flag = false;
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                if(flag == false) {
                    flag = true;
                    return validPalindrome(s.substring(i+1, j+1)) || validPalindrome(s.substring(i, j));
                } else {
                    return false;
                }
            }
            i++;
            j--;
        }
        return true;
    }
}
