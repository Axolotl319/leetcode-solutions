class Solution {
    public int minimumOperations(int[] nums) {
        Arrays.sort(nums); // smallest to largest
        int n = nums.length;
        int ops = 0;
        int index = 0;
        while(nums[n-1] > 0){
            while(index < n && nums[index] <= 0) index++;
            int x = nums[index];
            for(int i = index; i < n; i++){
                nums[i] -= x;
            }
            ops++;
        }
        return ops;
    }
}