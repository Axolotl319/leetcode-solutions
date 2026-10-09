class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0; int j = 0;
        while(j < nums.length){
            while(j < nums.length && nums[i] == nums[j]) j++;
            if(j < nums.length) nums[++i] = nums[j];
        }
        return i+1;
    }
}