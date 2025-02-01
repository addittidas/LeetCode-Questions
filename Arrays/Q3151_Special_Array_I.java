// 3151. Special Array I
/* An array is considered special if every pair of its adjacent elements contains two numbers with different parity.

You are given an array of integers nums. Return true if nums is a special array, otherwise, return false. */


public class Q3151_Special_Array_I {
    public boolean isArraySpecial(int[] nums) {
        if(nums.length == 1) return true;

        for(int i = 0; i < nums.length - 1; i++){
            if ((nums[i] + nums[i+1]) % 2 == 0)
                return false;
        }
        return true;
    }
}
