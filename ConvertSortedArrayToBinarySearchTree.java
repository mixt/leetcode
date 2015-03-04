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
    public TreeNode sortedArrayToBST(int[] num) {
        return build(num, 0, num.length - 1);
    }

    private TreeNode build(int[] num, int left,int right) {
        if(left > right) {
            return null;
        }
        int middle = (right + left) / 2;
        TreeNode node = new TreeNode(num[middle]);
        node.left = build(num, left, middle - 1);
        node.right = build(num, middle + 1, right);
        return node;
    }
}

/**
 * 采用递归求解，基本思想是不断二分，当前节点的左儿子是数组中节点值左边区间的中点，右儿子是右边区间的中点。
 * 注意递归时的输入值种的middle-1和middle+1，这是为了在到达树的最深层时能够满足终止条件left>right
 */