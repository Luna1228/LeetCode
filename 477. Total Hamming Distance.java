//477. Total Hamming Distance
//O(32n)
class Solution {
    public int totalHammingDistance(int[] nums) {
        int bitcount = 0;
        int res = 0;
        for(int i = 0; i < 32; i++) {
            bitcount = 0;
            for(int num: nums) {
                bitcount += (num >> i) & 1;
            }
            res += bitcount * (nums.length - bitcount);
        }
        return res;
    }
}
