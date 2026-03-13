class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n= s.length();
        int totalShift=0;
        char[] arr = s.toCharArray();

        for(int i=n-1; i>=0;i--){
            totalShift = (totalShift + shifts[i])%26;


            int newChar = (arr[i]-'a' + totalShift)%26;
            arr[i]= (char)('a'+newChar);
        }
        return new String(arr);
    }
}