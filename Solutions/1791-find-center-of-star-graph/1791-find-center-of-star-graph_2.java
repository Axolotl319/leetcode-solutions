class Solution {
    public int findCenter(int[][] edges) {
        // precondition: exactly one centre is guaranteed        
        HashMap<Integer, Integer> nodeFreq = new HashMap<>();
        for(int[] edge: edges){
            for(int i = 0; i < 2; i++){
                int freq = nodeFreq.getOrDefault(edge[i], 0) + 1;
                nodeFreq.put(edge[i], freq);
            }
        }

        int total = edges.length;
        for(int n: nodeFreq.keySet()){
            if(nodeFreq.get(n) == total){
                return n;
            }
        }
        return -1;
    }
}