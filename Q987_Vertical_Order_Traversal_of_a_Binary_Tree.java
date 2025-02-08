// 987. Vertical Order Traversal of a Binary Tree
/* Given the root of a binary tree, calculate the vertical order traversal of the binary tree.

For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively.
The root of the tree is at (0, 0).

The vertical order traversal of a binary tree is a list of top-to-bottom orderings
for each column index starting from the leftmost column and ending on the rightmost column.
There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.

Return the vertical order traversal of the binary tree. */

import java.util.*;

public class Q987_Vertical_Order_Traversal_of_a_Binary_Tree {
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

    public class Pair{
        TreeNode node;
        int x;
        int y;

        Pair(TreeNode node, int x, int y){
            this.node = node;
            this.x = x;
            this.y = y;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Pair> pq = new LinkedList<Pair>();
        pq.offer(new Pair(root, 0, 0));
        while(!pq.isEmpty()){
            Pair tuple = pq.poll();
            TreeNode node = tuple.node;
            int x = tuple.x;
            int y = tuple.y;

            if (!map.containsKey(x))
                map.put(x, new TreeMap<>());
            if (!map.get(x).containsKey(y))
                map.get(x).put(y, new PriorityQueue<>());
            map.get(x).get(y).offer(node.val); 
            if (node.left != null)
                pq.offer(new Pair(node.left, x-1, y+1));
            if (node.right != null)
                pq.offer(new Pair(node.right, x+1, y+1));  
        }
        List<List<Integer>> result = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()){
            result.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes: ys.values()){
                while(!nodes.isEmpty()){
                    result.get(result.size()-1).add(nodes.poll());
                }
            }
        }
        return result;
    }
}