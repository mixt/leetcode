/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(null == p && null == q) {
            return true;
        }
        else if(null == p || null == q) {
            return false;
        }
        else if(p.val == q.val) {
            boolean i = isSameTree(p.left, q.left);
            boolean j = isSameTree(p.right, q.right);
            return i && j;
        }
        else {
            return false;
        }
        
    }
}