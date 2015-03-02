/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        else if(head.next == head) {
            return true;
        }
        ListNode fhead = head.next;
        head.next = head;
        boolean result = hasCycle(fhead);
        return result;
    }
}