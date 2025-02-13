// 101. Symmetric Tree
/*  Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center). */

public class Q101_Symmetric_Tree {
    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        return root == null || symhelp(root.right, root.left);

    }
    public boolean symhelp(TreeNode left, TreeNode right){
        if (left == null || right == null) return left == right;
        if(left.val != right.val) return false;
        return symhelp(left.left, right.right) && symhelp(left.right, right.left);
    }
}
