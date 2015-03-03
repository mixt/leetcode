/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) { //检查输入值
            return;
        }
        TreeLinkNode top = root; //初始化两个变量
        TreeLinkNode head = root;
        while(head.left != null) {  //检查是否为最后一行
            top = head;             //换行
            head = head.left;       //存储下一行行头
            top.left.next = top.right; //连接行头的左右儿子
            while(top.next != null) {   //检查是否行尾
                top.right.next = top.next.left; //连接当前top的右儿子与下一个top的左儿子
                top = top.next;  //切换到下一个top
                top.left.next = top.right;  //连接当前top的左右儿子
            }
        }
    }
}

/**
 * 这个算法逐行操作，每次操作相邻的两行。创建两个点用于存储下一行的头和这一行目前正在操作的“顶点”（line 14,15)。
 * 对于正在操作的行的当前顶点，连接其右儿子与下一个顶点的左儿子以及下一个顶点的左儿子和右儿子(line 21~23)。然后迭代的
 * 操作下一个顶点，每次迭代时检查当前顶点的next是否为空，一旦为空就说明已到行尾(line 20)，这时检查下一行的行头即head
 * 是否是最后一行(line 16)，若不是则将其设为当前top并更新head为下一行行头(line 17,18)。
 * 注意line 19，每一行行头的左儿子与右儿子的连接是在这时候建立的。
 */