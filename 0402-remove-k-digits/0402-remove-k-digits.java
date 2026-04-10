class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        char[] ch = num.toCharArray();
        for(char digit : ch){
            while(!stack.isEmpty() && k>0 && stack.peek()>digit ){
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        while(k>0){
            stack.pop();
            k--;
        }
        StringBuilder result = new StringBuilder();
        for(char c: stack) result.append(c);

        while(result.length()>0 && result.charAt(0)=='0'){
            result.deleteCharAt(0);
        }
        

        return result.length() ==0? "0": result.toString();
    }
}