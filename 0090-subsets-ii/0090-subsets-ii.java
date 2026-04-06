class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); 
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;

        int total = 1 << n; 

        for(int mask = 0; mask < total; mask++) {
            List<Integer> subset = new ArrayList<>();

            for(int i = 0; i < n; i++) {
                if((mask & (1 << i)) != 0) {
                    subset.add(nums[i]);
                }
            }

            set.add(subset);  
        }

        return new ArrayList<>(set);
    }
}