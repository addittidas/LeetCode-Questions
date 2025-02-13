// 199. Binary Tree Right Side View
/*  Given the root of a binary tree, imagine yourself standing on the right side of it,
return the values of the nodes you can see ordered from top to bottom. */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q199_Binary_Tree_Right_Side_View {
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

    // Approach 1: Using Map
    public class Pair{
        TreeNode node;
        int x;

        Pair(TreeNode node, int x){
            this.node = node;
            this.x = x;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<Pair> pq = new LinkedList<>();
        pq.add(new Pair(root, 0));
        while(!pq.isEmpty()){
            Pair tuple = pq.poll();
            TreeNode node = tuple.node;
            int x = tuple.x;
            map.put(x, node.val);
            if (node.left != null)
                pq.add(new Pair(node.left, x+1));
            if (node.right != null)
                pq.add(new Pair(node.right, x+1));
        }
        for(int val : map.values())
            result.add(val);
        return result;
    }

    //Approach 2: Without using Map (Recursive)
    public List<Integer> rightSideView_rec(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        bfs(root, result, 0);
        return result;
    }
    public void bfs(TreeNode node, List<Integer> res , int x){
        if (node == null) return;
        if (x == res.size())
            res.add(node.val);
        if (node.right != null)
            bfs(node.right, res, x+1);
        if (node.left != null)
            bfs(node.left, res, x+1);
    }
}
