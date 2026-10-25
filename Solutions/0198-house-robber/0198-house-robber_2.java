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
            // find max so far not inc adj house
            int max = 0;
            for(int j = 0; j < i-1; j++){
                max = Math.max(max, money[j]);
            }
            money[i] = nums[i] + max;
        }
        return Math.max(money[n-2], money[n-1]);
    }
}