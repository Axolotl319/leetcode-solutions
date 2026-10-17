class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[] digitSums = new int[n];
        for(int i = 0; i < n; i++){
            digitSums[i] = calculateSum(nums[i]);
        }
        List<Pair> combo = new ArrayList<>();
        for(int i = 0; i < n; i++){
            Pair next = new Pair(nums[i], digitSums[i]);
            combo.add(next);
        }
        Collections.sort(combo, (p1, p2) -> {
            if(p1.snd == p2.snd){
                return p1.fst - p2.fst;
            }else{
                return p1.snd - p2.snd;
            }
        });
        int[] sorted = new int[n];
        for(int i = 0; i < n; i++){
            sorted[i] = combo.get(i).fst;
        }
        // compare nums and sorted
        int swaps = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == sorted[i]) continue;

            // perform swap
            for(int j = i; j < n; j++){
                if(nums[j] == sorted[i]){
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
            swaps++;
        }
        return swaps;
    }

    private int calculateSum(int n){
        int result = 0;
        while(n > 0){
            result += n%10;
            n /= 10;
        }
        return result;
    }

    protected class Pair{
        protected int fst;
        protected int snd;
        protected Pair(int x, int y){ fst = x; snd = y; }
        public String toString(){ return "("+fst+", "+snd+")"; }
    }
}