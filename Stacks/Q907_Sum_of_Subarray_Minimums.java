// 907. Sum of Subarray Minimums
/* Given an array of integers arr,
find the sum of min(b), where b ranges over every (contiguous) subarray of arr.
Since the answer may be large, return the answer modulo 109 + 7. */

import java.util.Stack;

public class Q907_Sum_of_Subarray_Minimums {
    public int sumSubarrayMins(int[] arr) {
        int[] pse = pse(arr);
        int[] nse = nse(arr);
        long sum = 0;
        int mod = (int) 1e9 + 7;

        for(int i = 0; i < arr.length; i++){
            long left = i - pse[i];
            long right = nse[i] - i;
            sum += (long) left * right % mod * arr[i] % mod;
            sum %= mod;
        }
        return (int)sum;
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
