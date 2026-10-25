class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length < 1 || obstacleGrid[0].length < 1) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] paths = new int[m][n];

        // base cases
        for(int i = 0; i < m && obstacleGrid[i][0] == 0; i++){
            // can only reach cells to the right before an obstacle by going straight there
            paths[i][0] = 1;
        }
        for(int i = 1; i < n && obstacleGrid[0][i] == 0; i++){
            paths[0][i] = 1;
        }
        
        // recursive cases
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(obstacleGrid[i][j] == 1){
                    paths[i][j] = 0;
                }else{
                    paths[i][j] = paths[i-1][j] + paths[i][j-1];
                }
            }
        }
        return paths[m-1][n-1];
    }
}