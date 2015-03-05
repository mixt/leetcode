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
    public ListNode swapPairs(ListNode head) {
        if(head == null) {  //检查输入为空的情况
            return null;
        }
        if(head.next == null) {  //输入list只有一个元素的情况
            return head;
        }
        ListNode finalhead = head.next;  //保存最终返回值即结果头部
        while(head.next.next != null && head.next.next.next != null) {  //如果从当前头部算起还有4个元素的话
            ListNode temp = head.next.next;  //保存第3个元素的引用
            head.next.next = head;    //第2个元素的next指向第1个元素，
            head.next = temp.next;    //第1个元素的next指向第4个元素                                  
            head = temp;   //将头重新设为第3个元素，准备进入下一次迭代，即每次迭代head往后移2位
        }
        if(head.next.next == null) {  //如果从当前头部算起还有2个元素的话
           head.next.next = head;
           head.next = null;
        }
        else {   //如果从当前头部算起还有3个元素的话
            ListNode temp = head.next.next;
            head.next.next = head;
            head.next = temp;
        }
        return finalhead;
    }
}