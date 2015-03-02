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

/**
 * 基本想法是顺序遍历list中的节点，使用某种方法标记已遍历过的节点，直到发现经过一个已被标记的节点，
 * 这时表明list中有cycle。这里的难点是如何在不使用额外内存的条件下在递归的过程中记录哪些节点已经遍历过。
 * 这里用的方法是每经过一个node就将它的next成员指向自己，然后继续遍历下一个node，直到经过某个node发现它的next是它自己，
 * 这时发现有cycle。这里遍历用递归实现。要注意的是无cycle的终止条件，其中head == null容易被忽略。
 */