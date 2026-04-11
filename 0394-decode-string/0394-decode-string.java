class Solution {
    public String decodeString(String s) {
        Stack<Integer> count = new Stack<>();
        Stack<String> string = new Stack<>();
        int k = 0;
        String curr = "";

        for (char ch : s.toCharArray()) {

            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            }

            else if (ch == '[') {
                count.push(k);
                string.push(curr);
                k = 0;
                curr = "";
            }

            else if (ch == ']') {
                int rep = count.pop();
                String prev = string.pop();

                StringBuilder temp = new StringBuilder(prev);
                for (int i = 0; i < rep; i++) {
                    temp.append(curr);
                }
                curr = temp.toString();
            }

            else {
                curr += ch;
            }
        }

        return curr;
    }
}