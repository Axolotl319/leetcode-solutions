class Solution {
    public int climbStairs(int n) {
        int[] ways = new int[n+1];
        for(int i = 0; i <= n; i++) ways[i] = -1;
        return waysStartingFrom(0, n, ways);
    }

    private int waysStartingFrom(int stair, int n, int[] ways){
        if(stair > n){
            return 0;
        }
        if(stair == n){
            // reached the top
            return ways[n] = 0;
        }
        if(ways[stair] != -1){
            return ways[stair];
        }
        ways[stair] = 1 + 
                        Math.max(waysStartingFrom(stair+1, n, ways),
                        waysStartingFrom(stair+1, n, ways));
        return ways[stair];
    }
}