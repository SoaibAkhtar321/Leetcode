import java.util.*;

class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Long> freq = new HashMap<>();
        
        long pairs = 0;
        long ans = 0;
        int left = 0;
        
        for (int right = 0; right < nums.length; right++) {
            
            long count = freq.getOrDefault(nums[right], 0L);
            pairs += count;              // new pairs formed
            freq.put(nums[right], count + 1);
            
            while (pairs >= k) {
                long leftCount = freq.get(nums[left]);
                freq.put(nums[left], leftCount - 1);
                pairs -= (leftCount - 1);  // remove pairs formed by left element
                left++;
            }
            
            ans += left;
        }
        
        return ans;
    }
}