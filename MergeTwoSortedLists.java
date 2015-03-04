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
        if(null == l1 && null == l2) {  //判断输入是否为2个空list
        	return null;
        }
        else if(null == l1) {   //判断是否l1空,l2不空
        	return l2;
        }
        else if(null == l2) {  //判断是否l2空l1不空
        	return l1;
        }
        ListNode head = (l1.val <= l2.val)?l1:l2;  //求结果的list头
        ListNode last = head;  //初始化last
        if(head == l1) {    //将head剔除出未处理的集合
        	l1 = l1.next;
        }
        else if(head == l2) {
        	l2 = l2.next;
        }
        while(l1 != null && l2 != null) {  //当l1和l2都不为空时
        	if(l1.val <= l2.val) {  //选择节点加入结果list并更新待合并的list
        		last.next = l1;
        		last = last.next;
        		l1 = l1.next;
        	}
        	else {
        		last.next = l2;
        		last = last.next;
        		l2 = l2.next;
        	}
        }
        if(null == l1) {  //当一个list已插入完，将另一个list剩下的节点插入结果list
        	while(l2 != null) {
        	    last.next = l2;
        	    last = last.next;
        	    l2 = l2.next;
        	}
        	return head;
        }
        else if(null == l2) {
        	while(l1 != null) {
        	    last.next = l1;
        	    last = last.next;
        	    l1 = l1.next;
        	}
        	return head;
        }
        return head;  //保证程序逻辑完备以通过编译
    }
}

/**
 * 这题的解法很琐碎，一堆条件判断，暂时没想到更优美的解法。
 */