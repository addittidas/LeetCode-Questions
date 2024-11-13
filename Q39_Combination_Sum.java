// 39. Combination Sum
/* Given an array of distinct integers candidates and a target integer target,
return a list of all unique combinations of candidates where the chosen numbers sum to target.
You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times.
Two combinations are unique if the frequency of at least one of the chosen numbers is different. */

import java.util.*;

class Q39_Combination_Sum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        func(0, candidates, list, target, new ArrayList<>());
        return list;
    }

    public void func(int ind, int[] arr, List<List<Integer>> list, int target, List<Integer> ds){
        if (ind == arr.length){
            if(target == 0){
                list.add(new ArrayList<>(ds));
            }
            return;
        }
        if (arr[ind] <= target){
            ds.add(arr[ind]);
            func(ind, arr, list, target - arr[ind], ds);
            ds.remove(ds.size() - 1);
        }
        func(ind + 1, arr, list, target, ds);
    }
}