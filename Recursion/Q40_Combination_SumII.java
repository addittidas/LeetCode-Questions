// 40. Combination Sum II
/* Given a collection of candidate numbers (candidates) and a target number (target),
find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination. */

import java.util.*;

class Q40_Combination_SumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        func(0, candidates, target, list, new ArrayList<>());
        return list;
    }

    public void func(int ind, int[] arr, int target, List<List<Integer>> list, List<Integer> ds){
        if (target == 0){
            list.add(new ArrayList<>(ds));
            return;
        }

        for (int i = ind; i < arr.length; i++){
            if (i > ind && arr[i] == arr[i - 1]) continue;
            if (arr[i] > target) break;

            ds.add(arr[i]);
            func(i + 1, arr, target - arr[i], list, ds);
            ds.remove(ds.size() - 1);
        }
    }
}