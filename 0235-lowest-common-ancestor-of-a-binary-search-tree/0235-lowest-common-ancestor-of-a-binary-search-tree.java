/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public static boolean path(TreeNode root,ArrayList<TreeNode>res,int a)
    {
        if(root==null)
        {
            return false;
        }
        res.add(root);
        if(root.val==a)
        {
            return true;
        }
        if(path(root.left,res,a)|| path(root.right,res,a))
        {
            return true;
        }
        res.remove(res.size()-1);
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode>p1=new ArrayList<>();
        ArrayList<TreeNode>q1=new ArrayList<>();
        
        path(root,p1,p.val);
        path(root,q1,q.val);
        int i=0;
        while(i<p1.size()&& i<q1.size()&& p1.get(i)==q1.get(i))
        {
            i++;
        }
        return q1.get(i-1);
        
        
    }
}