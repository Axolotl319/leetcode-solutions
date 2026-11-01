class Solution {
    public int minMoves(int[] nums) {
        // incrementing (n-1) nums = decrementing 1 num each time
        int min = Integer.MAX_VALUE;
        for(int n: nums){
            min = Math.min(n, min);
        }
        int moves = 0; // precondition: guaranteed to fit into 32 bits
        for(int n: nums){
            moves += (n - min);
        }
        return moves;
    }
}