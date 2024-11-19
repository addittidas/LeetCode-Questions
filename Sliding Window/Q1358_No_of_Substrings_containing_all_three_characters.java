// 1358. Number of Substrings Containing All Three Characters
/* Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c. */

class Q1358_No_of_Substrings_containing_all_three_characters {
    public int numberOfSubstrings(String s) {
        int[] seen = {-1, -1, -1};
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            seen[s.charAt(i) - 'a'] = i;
            count += 1 + Math.min(seen[0], Math.min(seen[1], seen[2]));
        }
        return count;
    }
}