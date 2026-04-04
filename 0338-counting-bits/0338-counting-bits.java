class Solution {
    public int[] countBits(int n) {
        int[] num = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            num[i] = num[i / 2] + (i % 2);
        }

        return num;
    }
}