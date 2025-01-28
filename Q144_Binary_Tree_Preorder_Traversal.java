// 144. Binary Tree Preorder Traversal
/* Given the root of a binary tree,
return the preorder traversal of its nodes' values. */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
 
    //Recursive Approach
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

    //Iterative Approach
    public List<Integer> preorderTraversal_iter(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack <TreeNode> st = new Stack<>();
        if (root == null)
            return list;
        st.push(root);
        while(!st.isEmpty()){
            root = st.pop();
            list.add(root.val);
            if (root.right != null)
                st.push(root.right);
            if (root.left != null)
                st.push(root.left);
        }
        return list;
    }
}
