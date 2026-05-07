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
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null) return res;
        getAllPaths(root, "");
        return res;
    }
    void getAllPaths(TreeNode node, String path){
        if(node == null) return;

        if(node.left == null && node.right == null){
            res.add(path + node.val);
            return;
        }

        getAllPaths(node.left, path + node.val + "->");
        getAllPaths(node.right, path + node.val + "->");
    }
}
