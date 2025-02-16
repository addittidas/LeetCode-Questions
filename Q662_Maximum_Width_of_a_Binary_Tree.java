// 662. Maximum Width of Binary Tree
/*  Given the root of a binary tree, return the maximum width of the given tree.

The maximum width of a tree is the maximum width among all levels.

The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes),
where the null nodes between the end-nodes that would be present in a complete binary tree
extending down to that level are also counted into the length calculation.

It is guaranteed that the answer will in the range of a 32-bit signed integer. */

import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class Q662_Maximum_Width_of_a_Binary_Tree {
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

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<Pair<TreeNode, Integer>> pq = new LinkedList<>();
        pq.offer(new Pair<>(root, 0));
        int maxwidth = 0;

        while(!pq.isEmpty()){
            int levsize = pq.size();
            int start = pq.peek().getValue();
            int end = 0;
            for(int i = 0; i < levsize; i++){
                Pair<TreeNode, Integer> entry = pq.poll();
                TreeNode node = entry.getKey();
                int pos = entry.getValue();
                end = pos;
                if (node.left != null) pq.offer(new Pair<>(node.left, pos*2));
                if (node.right != null) pq.offer(new Pair<>(node.right, pos*2 + 1));
            }
            maxwidth = Math.max(maxwidth, end - start + 1);
        }
        return maxwidth;
    }
}
