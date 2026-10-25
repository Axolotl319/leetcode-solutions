class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int layers = triangle.size();
        if(layers < 1) return 0;
        List<List<Integer>> minCost = new ArrayList<>();
        minCost.add(triangle.get(0));
        for(int i = 1; i < layers; i++){
            // layer i contains (i+1) numbers
            List<Integer> prevCost = minCost.get(minCost.size()-1);
            List<Integer> currCost = new ArrayList<>();
            for(int j = 0; j <= prevCost.size(); j++){
                if(j == 0){
                    currCost.add(prevCost.get(j)+triangle.get(i).get(j));
                }else if(j == prevCost.size()){
                    currCost.add(prevCost.get(j-1)+triangle.get(i).get(j));
                }else{
                    currCost.add(triangle.get(i).get(j) + Math.min(prevCost.get(j), prevCost.get(j-1)));
                }
            }
            minCost.add(currCost);
        }
        // find min of last row
        List<Integer> last = minCost.get(minCost.size()-1);
        int min = Integer.MAX_VALUE;
        for(int n: last){
            min = Math.min(min, n);
        }
        return min;
    }
}