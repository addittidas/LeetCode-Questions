// 144. Binary Tree Preorder Traversal
/* Given an array of integers arr,
find the sum of min(b), where b ranges over every (contiguous) subarray of arr.
Since the answer may be large, return the answer modulo 109 + 7. */

import java.util.ArrayList;
import java.util.List;

public class Q144_Binary_Tree_Preorder_Traversal {
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
 
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    public void preorder(TreeNode root, ArrayList<Integer> list){
        if (root == null){
            return;
        }
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }
}
