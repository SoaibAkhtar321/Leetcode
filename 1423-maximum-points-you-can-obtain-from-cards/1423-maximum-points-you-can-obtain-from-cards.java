class Solution {
    public int maxScore(int[] nums, int k) {
        int n = nums.length;
        int leftSum= 0;

        for(int i=0; i<k; i++){
            leftSum += nums[i];
        }
        int maxSum = leftSum;
        int rightSum=0;

        for(int i=0;i<k;i++){
            leftSum -= nums[k-1-i];
            rightSum += nums[n-1-i];

            maxSum = Math.max(maxSum, leftSum + rightSum);

        }
        return maxSum;
    }
}