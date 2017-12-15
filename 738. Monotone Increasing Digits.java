/**
 * created by Luna1228
 * way1: greedy O(n^2)
 * way2: greedy O(n)
 */
class Solution {
    /*public int monotoneIncreasingDigits(int N) {
     int bit = 1;
     int res = 0;
     while(N > 0) {
     if(isMono(N)) {
     return N*bit + res;
     }
     res += 9*bit;
     bit *= 10;
     N /= 10;
     N--;
     }
     return res;
     }
     
     public boolean isMono(int n) {
     int last = 9;
     while(n > 0) {
     int cur = n % 10;
     if(cur > last) return false;
     last = cur;
     n /= 10;
     }
     return true;
     }*/
    public int monotoneIncreasingDigits(int N) {
        String str = String.valueOf(N);
        int bit = 1;
        int pos = 0;
        for(; pos < str.length()-1; pos++) {
            if(str.charAt(pos) > str.charAt(pos+1)) {
                break;
            }
        }
        for(; pos > 0; pos--) {
            if(str.charAt(pos-1) != str.charAt(pos)) {
                break;
            }
        }
        if(pos == str.length()-1) return N;
        bit = (int)Math.pow(10, (str.length()-1-pos));
        return (N / bit-1)*bit + bit -1;
        
    }
}
