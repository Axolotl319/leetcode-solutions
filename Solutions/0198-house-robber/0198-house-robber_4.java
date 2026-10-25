class Solution {
    public int rob(int[] nums) {
        // precondition: 1 <= nums.length <= 100
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int[] money = new int[n+1];
        money[0] = 0;
        money[1] = nums[0];
        for(int i = 1; i < n; i++){
            // decide whether to skip or rob each house
            money[i+1] = Math.max(money[i], nums[i] + money[i-1]);
        }
        return money[n];
    }
}