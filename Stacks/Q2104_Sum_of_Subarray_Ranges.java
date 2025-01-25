// 2104. Sum of Subarray Ranges
/* You are given an integer array nums. 
The range of a subarray of nums is the difference between the largest and smallest element in the subarray.

Return the sum of all subarray ranges of nums.

A subarray is a contiguous non-empty sequence of elements within an array. */

import java.util.Stack;

public class Q2104_Sum_of_Subarray_Ranges {
    // Approach 1
    public long subArrayRanges(int[] nums) {
        long sum = 0;
        for(int i = 0; i < nums.length; i++){
            int min = nums[i];
            int max = nums[i];
            for(int j = i; j < nums.length; j++){
                min = Math.min(min, nums[j]);
                max  = Math.max(max, nums[j]);
                sum = sum + max - min;
            }
        }
        return sum;
    }
    
    // Approach 2
    public long subArrayRanges2(int[] nums) {
        int[] pse = pse(nums);
        int[] nse = nse(nums);
        int[] nge = nge(nums);
        int[] pge = pge(nums);
        long summin = 0;
        long summax = 0;
        long sum;

        for(int i = 0; i < nums.length; i++){
            long leftmin = i - pse[i];
            long rightmin = nse[i] - i;
            summin += leftmin*rightmin*nums[i];

            long leftmax = i - pge[i];
            long rightmax = nge[i] - i;
            summax += leftmax*rightmax*nums[i];
        }
        sum = summax - summin;
        return sum;
    }

    public int[] pse(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] ps = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
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
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
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

    public int[] nge(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] ng = new int[arr.length];
        for(int i = arr.length - 1; i >= 0; i--){
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                st.pop();
            }
            if(st.isEmpty())
                ng[i] = arr.length;
            else
                ng[i] = st.peek();
            st.push(i);
        }
        return ng;
    }

    public int[] pge(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] pg = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            while(!st.isEmpty() && arr[st.peek()] < arr[i]){
                st.pop();
            }
            if(st.isEmpty())
                pg[i] = -1;
            else
                pg[i] = st.peek();
            st.push(i);
        }
        return pg;
    }
}
