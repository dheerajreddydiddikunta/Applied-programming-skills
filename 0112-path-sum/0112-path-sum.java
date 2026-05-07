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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return hasPathSumHelper(root, targetSum);
    }
    
    private boolean hasPathSumHelper(TreeNode node, int remainingSum) {
        if (node == null) {
            return false;
        }
        
        // Subtract the node value from the remaining sum
        remainingSum -= node.val;
        
        // Check if it's a leaf node and if the remaining sum is zero
        if (node.left == null && node.right == null) {
            return remainingSum == 0;
        }
        
        // Recursively check the left and right subtrees
        return hasPathSumHelper(node.left, remainingSum) || hasPathSumHelper(node.right, remainingSum);
    }
}