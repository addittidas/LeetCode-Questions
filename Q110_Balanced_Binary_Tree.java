// 110. Balanced Binary Tree
/*  Given a binary tree, determine if it is height-balanced. */

public class Q110_Balanced_Binary_Tree {
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

    // Naive Solution
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int lh = findheight(root.left);
        int rh = findheight(root.right);

        if (Math.abs(lh - rh) > 1)
            return false;

        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);

        return !(!left || !right);
    }
    public int findheight(TreeNode root){
        if (root == null)
            return 0;
        return 1 + Math.max(findheight(root.left), findheight(root.right));
    }

    // Optimised So

    

}
