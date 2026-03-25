/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Base case: both trees are null, they are the same
        if (p == null && q == null) {
            return true;
        }
        
        // If one of the trees is null and the other is not, they are not the same
        if (p == null || q == null) {
            return false;
        }
        
        // Check if the current node values are the same, and recursively check left and right subtrees
        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}