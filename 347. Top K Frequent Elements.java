/**
 * created by Luna1228
 * 347. Top K Frequent Elements
 * Question description: https://leetcode.com/problems/top-k-frequent-elements/description/
 * PriorityQueue + HashMap
 * O(nlogk)
 */
 
 class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new LinkedList();
        Map<Integer, Integer> hash = new HashMap();
        for(int num: nums) {
            hash.put(num, hash.getOrDefault(num, 0)+1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue(new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2) {
                return hash.get(i1) - hash.get(i2);
            }
        });
        
        
        for(int key: hash.keySet()) {
            if(pq.size() < k) {
                pq.offer(key);
            } else if(hash.get(pq.peek()) <= hash.get(key)) {
                pq.remove(pq.peek());
                pq.offer(key);
            }
        }
        
        while(!pq.isEmpty()) {
            res.add(pq.poll());
        }
        return res;
    }
}
