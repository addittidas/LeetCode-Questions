// 9. Palindrome Number
/* Given an integer x, return true if x is a palindrome, and false otherwise. */

class Q9_PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }

        int temp = x;
        int reverse = 0;

        while (temp!= 0){
            int digit = temp % 10;
            reverse = reverse * 10 + digit;
            temp /= 10;
        }
        return (reverse == x);
    }
}