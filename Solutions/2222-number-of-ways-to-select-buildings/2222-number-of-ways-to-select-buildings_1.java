class Solution {
    public long numberOfWays(String s) {
        long totalZeros = 0;
        long totalOnes = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                totalZeros++;
            }else if(s.charAt(i) == '1'){
                totalOnes++;
            }else{
                // malformed
                return -1;
            }
        }
        long onesToTheLeft = 0;
        long onesToTheRight = totalOnes; // not necessary but makes code clearer
        long zerosToTheLeft = 0;
        long zerosToTheRight = totalZeros;
        long ways = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                ways += onesToTheLeft * onesToTheRight;
                zerosToTheLeft++;
                zerosToTheRight--;
            }else{
                ways += zerosToTheLeft * zerosToTheRight;
                onesToTheLeft++;
                onesToTheRight--;
            }
        }
        return ways;
    }
}