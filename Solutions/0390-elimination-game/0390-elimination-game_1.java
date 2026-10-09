class Solution {
    public int lastRemaining(int n) {
        if(n < 1) return -1;
        List<Integer> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            arr.add(i);
        }
        boolean forward = true; // left-to-right first
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