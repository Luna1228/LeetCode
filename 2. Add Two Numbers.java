/**
 * created by Luna1228
 * 2. Add Two Numbers
 * Question description: https://leetcode.com/problems/add-two-numbers/description/
 * Linked List
 */
 
 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int d1 = 0;
            int d2 = 0;
            if(l1 != null) {
                d1 = l1.val;
                l1 = l1.next;
            }
            
            if(l2 != null) {
                d2 = l2.val;
                l2 = l2.next;
            }
            
            int digit = d1 + d2 + carry;
            carry = digit/10;
            digit %= 10;
            cur.next = new ListNode(digit);
            cur = cur.next;
        }
        if(carry == 1) {
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }
}
