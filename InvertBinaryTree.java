/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        swap(root);
        return root;
    }
    
    private void swap(TreeNode node) {
        if(node == null) {
            return;
        }
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        if(node.left != null) {
            swap(node.left);
        }
        if(node.right != null) {
            swap(node.right);
        }
    }
}