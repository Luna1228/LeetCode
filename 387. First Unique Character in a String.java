//Time Complexity:O(n)
//Space Complexity: O(1)
class Solution {
    public int firstUniqChar(String s) {
        int[] hash = new int[26];
        Arrays.fill(hash, -1);
        for(int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if(hash[index] == -1) {
                hash[index] = i;
            } else {
                hash[index] = -2;
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < 26; i++) {
            if(hash[i] >= 0) {
                res = Math.min(res, hash[i]);
            }
        }
        return res == Integer.MAX_VALUE? -1: res;
    }
}
