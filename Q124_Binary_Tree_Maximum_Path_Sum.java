// 124. Binary Tree Maximum Path Sum
/* A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them.
A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

The path sum of a path is the sum of the node's values in the path.

Given the root of a binary tree, return the maximum path sum of any non-empty path. */

public class Q124_Binary_Tree_Maximum_Path_Sum {
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

    int maxsum;
    public int maxPathSum(TreeNode root) {
        maxsum = Integer.MIN_VALUE;
        findmaxsum(root);
        return maxsum;
    }

    public int findmaxsum(TreeNode root){
        if (root == null)
            return 0;
        int lsum = Math.max(0, findmaxsum(root.left));
        int rsum = Math.max(0, findmaxsum(root.right));

        maxsum = Math.max(maxsum, lsum + rsum + root.val);
        return root.val + Math.max(lsum, rsum);
    }
}
