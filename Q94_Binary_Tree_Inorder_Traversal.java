// 94. Binary Tree Inorder Traversal
/* Given the root of a binary tree,
return the inorder traversal of its nodes' values. */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q94_Binary_Tree_Inorder_Traversal {
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
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    public void inorder(TreeNode root, ArrayList<Integer> list){
        if (root == null){
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    //Iterative Approach
    public List<Integer> inorderTraversal_iter(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack <TreeNode> st = new Stack<>();
        if (root == null)
            return list;
        TreeNode node = root;
        while(true){
            if (node != null){
                st.push(node);
                node = node.left;
            }
            else{
                if(st.isEmpty()) break;
                node = st.pop();
                list.add(node.val);
                node = node.right;

            }
        }
        return list;
    }
}
