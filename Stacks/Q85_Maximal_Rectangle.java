// 85. Maximal Rectangle
/* Given a rows x cols binary matrix filled with 0's and 1's,
find the largest rectangle containing only 1's and return its area. */

import java.util.Stack;

public class Q85_Maximal_Rectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] height = new int[cols];
        int maxarea = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if (matrix[i][j] == '1')
                    height[j]++;
                else
                    height[j] = 0;
            }
            maxarea = Math.max(maxarea, lrec(height));
        }
        return maxarea;
    }
    public int lrec(int[] heights) {
        int[] pse = pse(heights);
        int[] nse = nse(heights);
        int max = 0;
        for(int i = 0; i < heights.length; i++){
            int left = pse[i];
            int right = nse[i];
            int area = heights[i]*(right-left-1);
            max = Math.max(max, area);
        }
        return max;
    }

    public int[] pse(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] ps = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(st.isEmpty())
                ps[i] = -1;
            else
                ps[i] = st.peek();

            st.push(i);
        }
        return ps;
    }

    public int[] nse(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] ns = new int[arr.length];
        for(int i = arr.length - 1; i >= 0; i--){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            if(st.isEmpty())
                ns[i] = arr.length;
            else
                ns[i] = st.peek();

            st.push(i);
        }
        return ns;
    }    
}
