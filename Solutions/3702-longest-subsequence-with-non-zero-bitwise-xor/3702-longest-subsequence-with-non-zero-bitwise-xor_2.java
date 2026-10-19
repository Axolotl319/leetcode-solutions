class Solution {
    public int longestSubsequence(int[] nums) {
        if(nums.length <= 0) return 0;
        int fullXor = nums[0];
        boolean allZero = true;
        for(int i = 1; i < nums.length; i++){
            fullXor ^= nums[i];
            if(nums[i] != 0){
                allZero = false;
            }
        }
        if(fullXor != 0){
            return nums.length;
        }else{
            return allZero ? 0 : nums.length-1;
        }
    }
}