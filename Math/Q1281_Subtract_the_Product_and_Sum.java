// 1281. Subtract the Product and Sum of Digits of an Integer
/* Given an integer number n, return the difference between the product of its digits and the sum of its digits. */

class Q1281_Subtract_the_Product_and_Sum {
    public int subtractProductAndSum(int n) {
        int num = n;
        int sum = 0;
        int prod = 1;

        while(num != 0){
            int digit = num % 10;
            sum += digit;
            num = num / 10;
        }

        num = n; 

        while(num != 0){
            int digit = num % 10;
            prod *= digit;
            num = num / 10;
        }

        int result = prod - sum;
        return result;
    }
}