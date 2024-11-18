// 3. Longest Substring Without Repeating Characters
/* Given a string s, find the length of the longest substring without repeating characters. */

import java.util.*;

class Q3_Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        Set <Character> set = new HashSet<>();
        int left = 0;
        int maxlen = 0;
        for(int right = 0; right < s.length(); right++){
            while(left < right && set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxlen = Math.max(maxlen, right - left + 1);
        }
        return maxlen;
    }
}