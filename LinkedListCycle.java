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
        ListNode fast = head;
        ListNode slow = head;
        if(head == null || head.next == null) {
            return false;
        }
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                return true;
            }
        }
        return false;
    }
}

/**
 * 这题的思路是设置两个游标，一个每次迭代向后走两步，叫fast，一个每次迭代走一步，叫slow。
 * 如果fast自己移动到null，则无环。如果fast和slow在某次迭代中指向了同一个节点，则有环。
 * 据说此题是微软经典面试题。。。。
 * 之前的一个解法虽然AC，但会破坏这个list，算了，太丢人了。
 */