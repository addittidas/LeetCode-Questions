// 496. Next Greater Element I
/* The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.

You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.

For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and
determine the next greater element of nums2[j] in nums2.
If there is no next greater element, then the answer for this query is -1.

Return an array ans of length nums1.length such that ans[i] is the next greater element as described above. */

import java.util.*;

class Q496_Next_Greater_Element_I {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // To find the next greater element for each element of the array.
        Stack<Integer> st = new Stack<>();
        int[] ng = new int[nums2.length];
        
        for (int i = nums2.length - 1; i >= 0; i--) {
           
            while (!st.isEmpty() && st.peek() <= nums2[i]) 
            {
                st.pop();
            }
            
            if (st.isEmpty()) {
                ng[i] = -1;
            } else {
                
                ng[i] = st.peek();
            }
            st.push(nums2[i]);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++){
            map.put(nums2[i], ng[i]);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++){
            result[i] = map.get(nums1[i]);
        }
        return result;
    }
}
