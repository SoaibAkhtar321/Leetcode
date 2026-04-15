class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();

        int maxcount = 0;

        for(int num : nums){
            int freq = map.getOrDefault(num, 0) + 1;
            map.put(num, freq);
            maxcount = Math.max(maxcount, freq);
        }

        int res = 0;
        for(int freq : map.values()){
            if(freq == maxcount){
                res += freq;
            }
        }

        return res;
    }
}