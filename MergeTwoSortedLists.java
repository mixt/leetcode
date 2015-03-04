/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 = null) {
        	return null;
        }
        else if(l1 == null) {
        	return l2;
        }
        else if(l2 == null) {
        	return l1;
        }
        ListNode head = (l1.val <= l2.val)?l1:l2;
        ListNode last = head;
        if(head == l1) {
        	l1 = l1.next;
        }
        else if(head == l2) {
        	l2 = l2.next;
        }
        while(l1 != null && l2 != null) {
        	if(l1.val <= l2.val) {
        		last.next = l1;
        		last = last.next;
        		l1 = l1.next;
        	}
        	if(l1.val > l2.val) {
        		last.next = l2;
        		last = last.next;
        		l2 = l2.next;
        	}
        }
        if(l1 == null) {
        	last.next = l2;
        }
        else if(l2 == null) {
        	last.next = l1;
        }
        return head;
    }
}