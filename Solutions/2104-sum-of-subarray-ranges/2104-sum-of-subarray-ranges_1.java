class Solution {
    public long subArrayRanges(int[] nums) {
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        long sum = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            min = nums[i]; max = nums[i];
            for(int j = i; j < n; j++){
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                sum += (max - min);
            }
        }
        return sum;
    }
}