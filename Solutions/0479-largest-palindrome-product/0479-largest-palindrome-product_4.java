class Solution {
    public int largestPalindrome(int n) {
        int smallest = 1;
        for(int i = 1; i < n; i++){
            smallest *= 10;
        }
        int largest = smallest * 10 - 1;
        long max = 0;
        for(long i = largest; i >= smallest; i--){
            for(long j = i; j >= smallest; j--){
                long mult = i * j;
                if(mult < max) break;
                if(palindrome(mult)){
                    max = Math.max(max, mult);
                }
            }
        }
        return (int) (max % 1337L);
    }

    private boolean palindrome(long n){
        String s = ""+n;
        int len = s.length();
        for(int i = 0; i <= len/2; i++){
            if(s.charAt(i) != s.charAt(len-1-i)){
                return false;
            }
        }
        return true;
    }
}