// 145. Binary Tree Postorder Traversal
/* Given the root of a binary tree,
return the postorder traversal of its nodes' values. */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q145_Binary_Tree_Postorder_Traversal {
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
    
    // Recursive Approach
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }

    public void postorder(TreeNode root, ArrayList<Integer> list){
        if (root == null){
            return;
        }
        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);
    }

    // Iterative Approach using 2 Stacks
    public List<Integer> postorderTraversal_2stack(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        if (root == null)
            return list;
        st1.push(root);
        while(!st1.isEmpty()){
            root = st1.pop();
            st2.push(root);
            if(root.left != null)
                st1.push(root.left);
            if(root.right != null)
                st1.push(root.right);
        }
        while(!st2.isEmpty()){
            list.add(st2.pop().val);
        }
        return list;
    }
}
