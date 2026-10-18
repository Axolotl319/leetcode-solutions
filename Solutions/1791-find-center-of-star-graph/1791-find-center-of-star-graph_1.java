class Solution {
    public int findCenter(int[][] edges) {
        // precondition: exactly one centre is guaranteed
        boolean[] centre = new boolean[edges.length + 1];
        for(int i = 0; i <= edges.length; i++){
            centre[i] = true;
        }
        for(int i = 0; i < edges.length; i++){
            for(int j = 0; j <= edges.length; j++){
                if(centre[j] && j != edges[i][0] && j != edges[i][1]){
                    centre[j] = false;
                }
            }
        }
        for(int i = 0; i <= edges.length; i++){
            if(centre[i]){
                return i; // 1-based
            }
        }
        return -1;
    }
}