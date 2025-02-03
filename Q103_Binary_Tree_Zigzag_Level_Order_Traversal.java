// 103. Binary Tree Zigzag Level Order Traversal
/* Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
(i.e., from left to right, then right to left for the next level and alternate between). */

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q103_Binary_Tree_Zigzag_Level_Order_Traversal {
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return result;
        
        boolean leftright = true;
        queue.add(root);

        while(!queue.isEmpty()){
            List<Integer> breadth = new ArrayList<>();
            int n = queue.size();

            for(int i = 0; i < n; i++){
                TreeNode node = queue.poll();
                breadth.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            if (!leftright)
                Collections.reverse(breadth);
            leftright = !leftright;
            result.add(breadth);
        }
        return result;
    }
}
