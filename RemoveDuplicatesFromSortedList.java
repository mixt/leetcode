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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {  //检查是否输入为空
            return null;
        }
        else if(head.next == null) {  //检查输入是否只包含一个节点
            return head;
        }
        ListNode last = head;  //当输入包含2个以上节点时初始化比较的前项和后项
        ListNode now = head.next;
        while(now != null) {  //检查是否到达List末尾
            if(now.val == last.val) {  //如果比较的前后项值相同，将前项的next指向更后面一项，并更新后项
                last.next = now.next;
                now = now.next;
            }
            else {  //如果比较的前后项值不同
                last = now;
                now = now.next;
            }
        }
        return head;
    }
}