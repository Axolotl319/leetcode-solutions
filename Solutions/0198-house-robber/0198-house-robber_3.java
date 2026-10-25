class Solution {
    public int rob(int[] nums) {
        // precondition: 1 <= nums.length <= 100
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int[] money = new int[n];
        money[0] = nums[0];
        money[1] = nums[1];
        for(int i = 2; i < n; i++){
            money[i] = nums[i] + money[i-2];
        }
        return Math.max(money[n-2], money[n-1]);
    }
}