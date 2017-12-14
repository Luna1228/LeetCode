/**
 * 思路：Divide and Conqure 
 *  对于任意operator，结果为左右结果的 l op r 的所有可能
 *  map 记录结果避免重复计算
 *  Time Complexity: O(n^2)
 *  Space Complexity: O(n^2)
 */
class Solution {
    HashMap<String, List<Integer>> map = new HashMap();
    public List<Integer> diffWaysToCompute(String input) {
        if(map.containsKey(input)) return map.get(input);
        List<Integer> res = new ArrayList();
        for(int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if(ch == '+' || ch == '-' || ch == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1));
                for(int l: left) {
                    for(int r: right) {
                        if(ch == '+') {
                            res.add(l+r);
                        } else if(ch == '-') {
                            res.add(l-r);
                        } else {
                            res.add(l*r);
                        }
                    }
                }
            }
            
        }
        if(res.size() == 0) res.add(Integer.valueOf(input));
        map.put(input, res);
        return res;
    }
}
