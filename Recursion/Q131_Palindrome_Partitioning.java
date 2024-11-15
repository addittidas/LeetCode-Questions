// 131. Palindrome Partitioning
/* Given a string s, partition s such that every substring of the partition is a palindrome.
Return all possible palindrome partitioning of s. */

import java.util.*;

class Q131_Palindrome_Partitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        List<String> path = new ArrayList<>();
        func(0, s, path, list);
        return list;
    }

    public void func(int ind, String s, List<String> path, List<List<String>> list){
        if (ind == s.length()){
            list.add(new ArrayList<>(path));
            return;
        }
        for(int i = ind; i < s.length(); i++){
            if(ispalindrome(s, ind, i)){
                path.add(s.substring(ind, i + 1));
                func(i + 1, s, path, list);
                path.remove(path.size() - 1);
            }
        }
    }

    public boolean ispalindrome(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}