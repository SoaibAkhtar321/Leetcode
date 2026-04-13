class Solution {
    public long continuousSubarrays(int[] nums) {
        Deque<Integer> minQ = new ArrayDeque<>();
        Deque<Integer> maxQ = new ArrayDeque<>();

        int l =0 ;
        long ans = 0;

        for(int r =0; r<nums.length;r++){
            while(!minQ.isEmpty() && nums[minQ.peekLast()]>nums[r]){
                minQ.pollLast();
            }
            minQ.addLast(r);

            while(!maxQ.isEmpty() && nums[maxQ.peekLast()]<nums[r]){
                maxQ.pollLast();
            }
            maxQ.addLast(r);

            while(nums[maxQ.peekFirst()]-nums[minQ.peekFirst()]>2){
                if(minQ.peekFirst()==l) minQ.pollFirst();
                if(maxQ.peekFirst()==l) maxQ.pollFirst();
                l++;
            }
            ans +=(r-l+1);


        }
        return ans;

    }
}