// 1423. Maximum Points You Can Obtain from Cards
/* There are several cards arranged in a row, and each card has an associated number of points.
The points are given in the integer array cardPoints.

In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.

Your score is the sum of the points of the cards you have taken.

Given the integer array cardPoints and the integer k, return the maximum score you can obtain. */

class Q1423_Maximum_Points_from_Cards {
    public int maxScore(int[] cardPoints, int k) {
        int lsum = 0;
        int rsum = 0;
        int maxscore = 0;
        int rtind = cardPoints.length - 1;

        for(int i = 0; i < k; i++){
            lsum += cardPoints[i];
            maxscore = lsum;
        } 

        for(int i = k - 1; i >= 0 ; i--){
            lsum -= cardPoints[i];
            rsum += cardPoints[rtind];
            rtind--;
            maxscore = Math.max(maxscore, (lsum + rsum));
        }
        return maxscore;
    }
}