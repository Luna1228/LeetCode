/**
 * created by Luna1228
 * num of power of four: 1) only have one 1 bit
 *                       2) have odd num f consecutive 0
 */

class Solution {
    public boolean isPowerOfFour(int num) {
        if(num <= 0) return false;
        return (num & (num-1)) == 0 && (num & 0x55555555) == num;
     }
}
