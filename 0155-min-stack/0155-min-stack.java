class MinStack {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> minst = new Stack<>();

    public void push(int val) {
        st.push(val);

        if (minst.isEmpty() || val <= minst.peek()) {
            minst.push(val);   // ✅ FIX
        }
    }
    
    public void pop() {
        if (st.peek().equals(minst.peek())) {
            minst.pop();
        }
        st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minst.peek();
    }
}