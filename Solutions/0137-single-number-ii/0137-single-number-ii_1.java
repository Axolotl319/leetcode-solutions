class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> seen = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int f = seen.getOrDefault(nums[i], 0);
            seen.put(nums[i], f+1);
        }
        for(int i = 0; i < nums.length; i++){
            if(seen.get(nums[i]) < 3) return nums[i];
        }
        return -1;
    }
}