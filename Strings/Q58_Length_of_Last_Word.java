// 58. Length of Last Word
/* Given a string s consisting of words and spaces, return the length of the last word in the string.

A word is a maximal substring consisting of non-space characters only. */

class Q58_Length_of_Last_Word {
    public int lengthOfLastWord(String s) {
        String str = s.trim();
        int length = 0;
        for(int i = str.length() - 1; i >= 0; i--){
            length++;
            if (str.charAt(i) == ' '){
                length--;
                break;
            }
        }
        return length;
    }
}
