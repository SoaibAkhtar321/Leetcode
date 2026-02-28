class Solution {
    public int minimumRecolors(String s, int k) {
        int w= 0;
        int min =k;
        for(int i=0; i<s.length();i++){
            if(s.charAt(i)=='W'){
                w++;
            }
            if(i>=k && s.charAt(i-k)=='W') w--;

            if(i>=k-1) min= Math.min(min,w);
        }
        return min;
    }
}