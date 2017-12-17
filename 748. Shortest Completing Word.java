/**
 * created by Luna1228
 * 748. Shortest Completing Word
 * Question Description: https://leetcode.com/problems/shortest-completing-word/description/
 */
 
 class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] hash = new int[26];
        int len = 0;
        for(char ch: licensePlate.toCharArray()) {
            if(Character.isUpperCase(ch)) {
                len++;
                hash[ch-'A']++;
            } else if(Character.isLowerCase(ch)) {
                len++;
                hash[ch-'a']++;
            }
        }
        
        String res = null;
        for(String word: words) {
            if(res == null || word.length() < res.length()) {
                if(valid(word, hash, len)) {
                    res = word;
                }
            }
        }
        return res;
    }
    
    public boolean valid(String word, int[] hash, int len) {
        int[] copy = new int[26];
        for(int i = 0; i < 26; i++) {
            copy[i] = hash[i];
        }
        for(char ch: word.toCharArray()) {
            if(Character.isUpperCase(ch)) {
                if(copy[ch-'A'] > 0) {
                    copy[ch-'A']--;
                    len--;
                }
            } else if(Character.isLowerCase(ch)) {
                if(copy[ch-'a'] > 0) {
                    copy[ch-'a']--;
                    len--;
                }
            }
            if(len == 0) return true;
        }
        return len == 0;
    }
}
