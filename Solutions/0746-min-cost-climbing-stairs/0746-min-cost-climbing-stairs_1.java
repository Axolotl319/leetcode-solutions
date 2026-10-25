class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length < 1) return 0;
        if(cost.length == 1) return cost[0];
        int[] minCost = new int[cost.length+1];
        minCost[0] = 0; // cost to reach step 0
        minCost[1] = cost[0];
        for(int i = 1; i < cost.length; i++){
            minCost[i+1] = cost[i] + Math.min(minCost[i], minCost[i-1]);
        }
        // min of taking 1 or 2 steps at end
        return Math.min(minCost[cost.length], minCost[cost.length-1]);
    }
}