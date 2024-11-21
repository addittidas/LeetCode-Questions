// 992. Subarrays with K Different Integers
/* Given an integer array nums and an integer k, return the number of good subarrays of nums.

A good array is an array where the number of different integers in that array is exactly k.

For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.

Note: A subarray is a contiguous part of an array. */

import java.util.*;

class Q992_Subarrays_with_K_Different_Integers {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int count = func(nums, k) - func(nums, k - 1);
        return count;
    }
    public int func(int[] arr, int k){
        Map<Integer, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int count = 0;

        if (k == 0)
            return 0;

        while(r < arr.length){
            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);
            
            while (map.size() > k && l <= r){
                map.put(arr[l], map.get(arr[l]) - 1);
                if(map.get(arr[l]) == 0)
                    map.remove(arr[l]);
                l++;
            }
            count += (r - l + 1);
            r++;
        }
        return count;
    }
}