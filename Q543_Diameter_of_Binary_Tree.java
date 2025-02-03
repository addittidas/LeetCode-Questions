// 543. Diameter of Binary Tree
/* Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them. */

public class Q543_Diameter_of_Binary_Tree {
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

    int diam;
    public int diameterOfBinaryTree(TreeNode root) {
        diam = 0;
        finddiam(root);
        return diam;
    }
    
    public int finddiam(TreeNode root){
        if (root == null)
            return 0;
        int lh = finddiam(root.left);
        int rh = finddiam(root.right);

        diam = Math.max(diam, lh + rh);

        return 1 + Math.max(lh, rh);
    }
}
