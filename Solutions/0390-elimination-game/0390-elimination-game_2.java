class Solution {
    public int lastRemaining(int n) {
        if(n < 1) return -1;
        if(n == 1) return 1;
        List<Integer> arr = new ArrayList<>();
        // all odds always removed in first pass so don't add in first place
        for(int i = 2; i <= n; i += 2){
            arr.add(i);
        }
        boolean forward = false; // left-to-right first - already done
        while(arr.size() > 1){
            if(forward){
                int i = 0;
                while(i < arr.size()){
                    arr.remove(i);
                    i++;
                }
            }else{
                int i = arr.size() - 1;
                while(i >= 0){
                    arr.remove(i);
                    i -= 2;
                }
            }
            forward = !forward; // reverse direction
        }
        return arr.get(0);
    }
}