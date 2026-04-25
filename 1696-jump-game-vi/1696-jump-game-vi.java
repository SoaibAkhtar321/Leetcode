class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];

        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(0); // store indices

        for (int i = 1; i < n; i++) {

            // 1. Remove indices out of window
            while (!dq.isEmpty() && dq.peekFirst() < i - k) {
                dq.pollFirst();
            }

            // 2. Use best previous result
            dp[i] = nums[i] + dp[dq.peekFirst()];

            // 3. Maintain decreasing order of dp
            while (!dq.isEmpty() && dp[dq.peekLast()] <= dp[i]) {
                dq.pollLast();
            }

            // 4. Add current index
            dq.offerLast(i);
        }

        return dp[n - 1];
    }
}