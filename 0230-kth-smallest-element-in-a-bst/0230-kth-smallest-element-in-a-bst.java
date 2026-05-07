class Solution {
    public List<Integer> arr = new ArrayList<>();

    public void dfsInOrder(TreeNode root) {
        if (root == null) return;
        dfsInOrder(root.left);
        arr.add(root.val);
        dfsInOrder(root.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        dfsInOrder(root);
        return arr.get(k - 1);
    }
}