class Solution {
    public int minDistance(String word1, String word2) {
        // dp[i][j] = operations to transform word1.substring(0, i) into word2.substring(0, j)
        int m = word1.length(); int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i <= m; i++){
            dp[i][0] = i; // i deletions
        }
        for(int j = 0; j <= n; j++){
            dp[0][j] = j; // j insertions
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    int delete = dp[i-1][j]; // delete from word1
                    int insert = dp[i][j-1]; // or delete from word2
                    int replace = dp[i-1][j-1]; // or delete from both
                    dp[i][j] = 1 + Math.min(delete, Math.min(insert, replace));
                }
            }
        }

        return dp[m][n];    
    }
}