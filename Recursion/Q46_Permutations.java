// 46. Permutations
/* Given an array nums of distinct integers, return all the possible permutations.
You can return the answer in any order. */

import java.util.*;

// Approach 1
class Q46_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        func(list, nums, ds, freq);
        return list;
        
    }
    public void func(List<List<Integer>> list, int[] arr, List<Integer> ds, boolean[] freq){
        if (ds.size() == arr.length){
            list.add(new ArrayList<>(ds));
            return;
        }

        for(int i = 0; i < arr.length; i++){
            if(!freq[i]){
                freq[i] = true;
                ds.add(arr[i]);
                func(list, arr, ds, freq);
                ds.remove(ds.size() - 1);
                freq[i] = false;
            }
        }
    }
}

// Approach 2
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        func(0, nums, list);
        return list;
    }
    public void swap(int a, int b, int[] arr){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public void func(int ind, int[] arr, List<List<Integer>> list){
        if (ind == arr.length){
            List<Integer> ds = new ArrayList<>();
            for(int i = 0; i < arr.length; i++){
                ds.add(arr[i]);
            }
            list.add(new ArrayList<>(ds));
            return;
        }

        for(int i = ind; i < arr.length; i++){
            swap(i, ind, arr);
            func(ind + 1, arr, list);
            swap(i, ind, arr);
        }
    }
}