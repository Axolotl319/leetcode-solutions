class Solution {
    public int fib(int n) {
        if(n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        }
        int[] fibnums = new int[n+1];
        fibnums[0] = 0; fibnums[1] = 1;
        for(int i = 2; i <= n; i++){
            fibnums[i] = fibnums[i-1] + fibnums[i-2];
        }
        return fibnums[n];
    }
}