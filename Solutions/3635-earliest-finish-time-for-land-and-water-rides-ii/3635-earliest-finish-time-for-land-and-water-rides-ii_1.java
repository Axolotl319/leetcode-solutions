class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int m = landStartTime.length;
        int n = waterStartTime.length;
        int[][] times = new int[m][n];
        int earliest = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                finishTime(landStartTime, landDuration, waterStartTime, waterDuration, times, i, j); // sets times[i][j]
                earliest = Math.min(earliest, times[i][j]);
            }
        }

        return earliest;
    }

    private void finishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration, int[][] endTimes, int i, int j){
        // endTimes[i][j] = earliest time they can leave if they do land ride i and water ride j

        // check if it is possible to complete one before other opens
        if(landStartTime[i] + landDuration[i] <= waterStartTime[j]){
            endTimes[i][j] = waterStartTime[j] + waterDuration[j];
            return;
        }

        if(waterStartTime[j] + waterDuration[j] <= landStartTime[i]){
            endTimes[i][j] = landStartTime[i] + landDuration[i];
            return;
        }

        // time if start with land
        int timeStartingLand = landStartTime[i] + landDuration[i] + waterDuration[j];
        // time if start with water
        int timeStartingWater = waterStartTime[j] + waterDuration[j] + landDuration[i];
        endTimes[i][j] = Math.min(timeStartingLand, timeStartingWater);
    }
}