class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[] digitSums = new int[n];
        for(int i = 0; i < n; i++){
            digitSums[i] = calculateSum(nums[i]);
        }

        // Arrays.sort not allowed on primitive types (int)
        Integer[] sortedIndexes = new Integer[n];
        for(int i = 0; i < n; i++){
            sortedIndexes[i] = i;
        }
        Arrays.sort(sortedIndexes, (a, b) -> {
            if(digitSums[a] == digitSums[b]){
                return nums[a] - nums[b];
            }else{
                return digitSums[a] - digitSums[b];
            }
        });
        System.out.println(Arrays.toString(sortedIndexes));

        int[] positions = new int[n];
        for(int i = 0; i < n; i++){
            int sorted = sortedIndexes[i];
            positions[sorted] = i;
        }

        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++) visited[i] = false;
        int cycles = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                cycles++;
                int j = i;
                while(!visited[j]){
                    visited[j] = true;
                    j = positions[j];
                }
            }
        }

        return n - cycles;
    }

    private int calculateSum(int n){
        int result = 0;
        while(n > 0){
            result += n%10;
            n /= 10;
        }
        return result;
    }
}