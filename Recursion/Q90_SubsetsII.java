// 90. Subsets II
/* Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.*/

import java.util.*;

class Q90_SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        func(0, nums, n, list, new ArrayList<>());
        return list;
    }

    public void func(int ind, int[] arr, int n, List<List<Integer>> list, List<Integer> ds){
        list.add(new ArrayList<>(ds));

        for(int i = ind; i < n; i++){
            if (i != ind && arr[i] == arr[i - 1]) continue;
            ds.add(arr[i]);
            func(i + 1, arr, n, list, ds);
            ds.remove(ds.size() - 1);
        }
    }
}