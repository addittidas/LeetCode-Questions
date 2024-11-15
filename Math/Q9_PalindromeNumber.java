// 7. Reverse Integer
/* Given a signed 32-bit integer x, return x with its digits reversed.
If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned). */

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