// 503. Next Greater Element II
/* Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]),
return the next greater number for every element in nums.

The next greater number of a number x is the first greater number to its traversing-order next in the array,
which means you could search circularly to find its next greater number.
If it doesn't exist, return -1 for this number. */

import java.util.*;

class Q503_Next_Greater_Element_II {
    public int[] nextGreaterElements(int[] nums) {
        // To find the next greater element for each element of the array.
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] ng = new int[n];

        for (int i = 2*n - 1; i >= 0; i--) {           
            while (!st.isEmpty() && st.peek() <= nums[i%n]) 
            {
                st.pop();
            }
            if (i < n){
                if (st.isEmpty()) 
                    ng[i] = -1;
                else 
                    ng[i] = st.peek();
            }
            st.push(nums[i%n]);
        }
        return ng;
    }
}
