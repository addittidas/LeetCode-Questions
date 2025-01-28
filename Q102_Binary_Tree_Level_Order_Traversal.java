// 102. Binary Tree Level Order Traversal
/* Given the root of a binary tree,
return the level order traversal of its nodes' values. (i.e., from left to right, level by level). */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q102_Binary_Tree_Level_Order_Traversal {
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
 
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue <TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> result = new LinkedList<List<Integer>>();

        if (root == null)
            return result;

        queue.offer(root);
        
        while(!queue.isEmpty()){
            List<Integer> levelterm = new LinkedList<>();
            int num = queue.size();
            for(int i = 0; i < num; i++){
                if (queue.peek().left != null)
                    queue.offer(queue.peek().left);
                if (queue.peek().right != null)
                    queue.offer(queue.peek().right);
                levelterm.add(queue.poll().val);
            }
            result.add(levelterm);
        }
        return result;
    }
}
