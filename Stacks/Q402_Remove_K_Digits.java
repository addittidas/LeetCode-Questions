// 402. Remove K Digits
/* Given string num representing a non-negative integer num, and an integer k,
return the smallest possible integer after removing k digits from num. */

import java.util.Stack;

public class Q402_Remove_K_Digits {
    public String removeKdigits(String num, int k) {
        if(num.length() == k)
            return "0";

        Stack<Character> st = new Stack<>();
        for(int i = 0; i < num.length(); i++){
            while(!st.isEmpty() && k > 0 && st.peek() - '0' > num.charAt(i) - '0'){
                st.pop();
                k--;
            }

            if(st.isEmpty() || k >= 0){
                st.push(num.charAt(i));
            }
        }

        while(k > 0){
            st.pop();
            k--;
        }

        if(st.isEmpty())
            return "0";

        StringBuilder res = new StringBuilder();
        while(!st.isEmpty())
            res.append(st.pop());

        res.reverse();
        
        while(res.length() > 1 && res.charAt(0) == '0')
            res.deleteCharAt(0);

        return res.toString();
    }
}
