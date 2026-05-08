class Solution {
    public boolean canJump(int[] nums) {
        int fartest =0;
        for(int i=0; i<nums.length;i++){
            if(i>fartest) return false;

            fartest = Math.max(fartest , i+nums[i]);

            if(fartest>=nums.length-1) return true;
        }
        return true;
        
    }
}