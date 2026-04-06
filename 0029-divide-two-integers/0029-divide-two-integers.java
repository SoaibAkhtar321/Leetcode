class Solution {
    public int divide(int dividend, int divisor) {

        // overflow case
        if(dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // sign
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;

        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        int quotient = 0;

        while(dvd >= dvs) {
            int shift = 0;

            // find max shift
            while(dvd >= (dvs << (shift + 1))) {
                shift++;
            }

            // update AFTER loop
            quotient += (1 << shift);
            dvd -= (dvs << shift);
        }

        return sign == 1 ? quotient : -quotient;
    }
}