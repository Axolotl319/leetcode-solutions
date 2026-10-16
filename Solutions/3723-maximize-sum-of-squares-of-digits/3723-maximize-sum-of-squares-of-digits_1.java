class Solution {
    public String maxSumOfSquares(int num, int sum) {
        int smallest = 1;
        for(int i = 1; i < num; i++){
            smallest *= 10;
        }
        List<Integer> goodies = new ArrayList<>();
        for(int n = smallest; n < smallest*10; n++){
            if(isGood(n, sum)){
                goodies.add(n);
            }
        }
        int maxScore = 0;
        String answer = "";
        for(int n: goodies){
            int score = score(n);
            if(score >= maxScore){
                maxScore = score;
                answer = ""+n;
            }
        }
        return answer;
    }

    private boolean isGood(int n, int sum){
        int s = 0;
        while(n > 0){
            s += n%10;
            n /= 10;
        }
        return s == sum;
    }

    private int score(int n){
        int result = 0;
        while(n > 0){
            int digit = n % 10;
            result += digit*digit;
            n /= 10;
        }
        return result;
    }
}