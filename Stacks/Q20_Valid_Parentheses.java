// 20. Valid Parentheses
/* Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

i) Open brackets must be closed by the same type of brackets.
ii) Open brackets must be closed in the correct order.
iii) Every close bracket has a corresponding open bracket of the same type. */

import java.util.*;

class Q20_Valid_Parentheses {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                st.push(')');
            }
            else if(s.charAt(i) == '{'){
                st.push('}');
            }
            else if(s.charAt(i) == '['){
                st.push(']');
            }
            else if(st.isEmpty() || st.pop() != s.charAt(i)){
                return false;
            }
        }
        return st.isEmpty();
        
    }
}