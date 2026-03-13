class Solution {
    public int numOfSubarrays(int[] arr) {
        int odd = 0, even = 1;
        int sum = 0;
        long count = 0;
        int mod = 1000000007;

        for(int num : arr){
            sum += num;

            if(sum % 2 == 0){
                count += odd;
                even++;
            }else{
                count += even;
                odd++;
            }

            count %= mod;
        }

        return (int)count;
    }
}