// 84. Largest Rectangle in Histogram
/* Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
return the area of the largest rectangle in the histogram. */

import java.util.Stack;

public class Q84_Largest_Rectangle_in_Histogram {
    public int largestRectangleArea(int[] heights) {
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
