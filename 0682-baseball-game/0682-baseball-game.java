import java.util.*;

class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> st = new Stack<>();

        for (String op : ops) {

            if (op.equals("+")) {
                int top = st.pop();
                int newScore = top + st.peek(); // safer
                st.push(top);                   // restore
                st.push(newScore);

            } else if (op.equals("D")) {
                st.push(2 * st.peek());

            } else if (op.equals("C")) {
                st.pop();

            } else {
                st.push(Integer.parseInt(op));
            }
        }

        int sum = 0;
        for (int num : st) {
            sum += num;
        }

        return sum;
    }
}