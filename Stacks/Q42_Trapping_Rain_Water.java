// 42. Trapping Rain Water
/* Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it can trap after raining. */

public class Q42_Trapping_Rain_Water {
    //Approach 1
    public int trap(int[] height) {
        int ans = 0;

        int[] prefix = new int[height.length];
        prefix[0] = height[0];
        for(int i = 1; i < height.length; i++){
            prefix[i] = Math.max(prefix[i - 1], height[i]);
        }
        
        int[] sufix = new int[height.length];
        sufix[height.length-1] = height[height.length-1];
        for(int i = height.length - 2; i >= 0; i--){
            sufix[i] = Math.max(sufix[i + 1], height[i]);
        }

        for(int i = 0; i < height.length; i++){
            int leftmax = prefix[i];
            int rightmax = sufix[i];
            if(height[i] < leftmax && height[i] < rightmax)
                ans += Math.min(leftmax, rightmax) - height[i];
        }
        return ans;
    }

    //Approach 2
    public int trap2(int[] height) {
        int ans = 0;
        int l = 0;
        int r = height.length - 1;
        int leftmax = height[l];
        int rightmax = height[r];

        while(l < r){
            if (leftmax < rightmax){
                l++;
                leftmax = Math.max(leftmax, height[l]);
                ans += leftmax - height[l];
            }
            else{
                r--;
                rightmax = Math.max(rightmax, height[r]);
                ans += rightmax - height[r];
            }
        }
        return ans;
    }
}
