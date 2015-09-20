/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if((inLeft(root, p) && inRight(root, q)) || (inLeft(root, q) && inRight(root, p))) {
            return root;
        }
        else if(inLeft(root, p) && inLeft(root, q)) {
            return lowestCommonAncestor(root.left, p, q);
        }
        else if(inRight(root, p) && inRight(root, q)) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return null;
    }
    
    private boolean search(TreeNode root, TreeNode node) {
        if(root == null) {
            return false;
        }
        if(root == node) {
            return true;
        }
        return (search(root.left, node) || search(root.right, node));
        
    }
    
    private boolean inLeft(TreeNode root, TreeNode node) {
        if(root == node) {
            return true;
        }
        return search(root.left, node);
    }
    
    private boolean inRight(TreeNode root, TreeNode node) {
        if(root == node) {
            return true;
        }
        return search(root.right, node);
    }
}