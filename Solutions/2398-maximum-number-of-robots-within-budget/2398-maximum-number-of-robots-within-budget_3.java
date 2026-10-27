class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        if(chargeTimes.length < 1 || chargeTimes.length != runningCosts.length || budget <= 0){
            // malformed problem
            return -1;
        }
        int i = 0; int j = 1; // run robots in [i, j)
        int numRobots = 0;
        long maxTime = chargeTimes[i];
        long sum = runningCosts[i];
        while(i < j && j <= chargeTimes.length){
            long cost = totalCost(maxTime, j-i, sum);
            if(cost <= budget && j < chargeTimes.length){
                numRobots = Math.max(numRobots, j-i);
                // include an extra robot
                sum += runningCosts[j];
                maxTime = Math.max(maxTime, chargeTimes[j]);
                j++;
            }else{
                // remove i
                sum -= runningCosts[i];
                if(chargeTimes[i] == maxTime){
                    maxTime = Integer.MIN_VALUE;
                    for(int x = i+1; x < j; x++){
                        maxTime = Math.max(maxTime, chargeTimes[x]);
                    }
                }
                i++;
            }
        }
        return numRobots;
    }

    private long totalCost(long max, int k, long sum){
        return max + k * sum;
    }
}