// 930. Binary Subarrays With Sum
/* Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.

A subarray is a contiguous part of the array. */

class Q930_Binary_Subarrays_with_sum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = numsubarraysum(nums, goal) - numsubarraysum(nums, goal - 1);
        return count;
    }
    public int numsubarraysum(int[] arr, int goal){
        int l = 0;
        int r = 0;
        int sum = 0;
        int count = 0;
        if(goal < 0){
            return 0;
        }
        while(r < arr.length){
            sum += arr[r];
            while(sum > goal){
                sum -= arr[l];
                l++;
            }
            count += (r - l + 1);
            r++;
        }
        return count;
    }
}