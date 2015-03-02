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
    List<Integer> traversal = new ArrayList();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(null != root) {
            traversal.add(root.val);
            traversal = preorderTraversal(root.left);
            traversal = preorderTraversal(root.right);
        }
        return traversal;
    }
}

/**
 * 比较标准的二叉树前序遍历，注意作为返回值的list在函数外定义并初始化
 */