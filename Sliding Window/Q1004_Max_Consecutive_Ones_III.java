// 1004. Max Consecutive Ones III
/* Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's. */

class Q1004_Max_Consecutive_Ones_III {
    public int longestOnes(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int count = 0;
        int maxlen = 0;
        while(r < nums.length){
            if(nums[r] == 0){
                count++;
            }
            if (count > k){
                if(nums[l] == 0){
                    count--;
                }
                l++;
            }
            if(count <= k){
                int len = r - l + 1;
                maxlen = Math.max(maxlen, len);
            }
            r++;
        }
        return maxlen;
    }
}