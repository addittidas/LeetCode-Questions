// 735. Asteroid Collision
/* We are given an array asteroids of integers representing asteroids in a row.
The indices of the asteriod in the array represent their relative position in space.

For each asteroid, the absolute value represents its size, and the sign represents its direction
(positive meaning right, negative meaning left).
Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions.
If two asteroids meet, the smaller one will explode.
If both are the same size, both will explode.
Two asteroids moving in the same direction will never meet. */

import java.util.Stack;

public class Q735_Asteroid_Collision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack <Integer> st = new Stack<>();
        for(int i = 0; i < asteroids.length; i++){
            if (asteroids[i] > 0){
                st.push(asteroids[i]);
            }
            else{
                while (!st.isEmpty() && st.peek() > 0 && st.peek() < -asteroids[i]) {
                    st.pop();
                }

                if (st.isEmpty() || st.peek() < 0)  {
                    st.push(asteroids[i]);
                }

                if (st.peek() == -asteroids[i]) {
                    st.pop();
                }
            }
        }
        int[] result = new int[st.size()];
        int i = st.size() - 1;

        while(!st.isEmpty()) {
            result[i--] = st.pop();
        }

        return result; 
    }
}
