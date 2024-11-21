//1248. Count Number of Nice Subarrays
/* Given an array of integers nums and an integer k.
A continuous subarray is called nice if there are k odd numbers on it.

Return the number of nice sub-arrays. */

class Q1248_Count_Number_of_Nice_Subarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        int count = func(nums, k) - func(nums, k - 1);
        return count;
    }

    public int func(int[] arr, int k){
        int count = 0;
        int sum = 0;
        int l = 0;
        int r = 0;
        while(r < arr.length){
            sum += arr[r] % 2;
            while(sum > k){
                sum -= arr[l] % 2;
                l++;
            }
            count += (r - l + 1);
            r++;
        }
        return count;
    }
}