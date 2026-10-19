class Solution {
    public int longestSubsequence(int[] nums) {
        return longest(nums, 0, 0, 0);
    }

    private int longest(int[] nums, int currXor, int index, int currMaxLen){
        if(index >= nums.length){
            return currMaxLen;
        }
        int nextXor = nums[index] ^ currXor;
        if(nextXor != 0){
            int including = longest(nums, nextXor, index+1, currMaxLen+1);
            int excluding = longest(nums, currXor, index+1, currMaxLen);
            return Math.max(including, excluding);
        }else{
            return longest(nums, currXor, index+1, currMaxLen);
        }
    }
}