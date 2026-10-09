class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int sum = 0;
        int rem = x;
        while(rem > 0){
            sum += rem % 10;
            rem /= 10;
        }
        return x % sum == 0 ? sum : -1;
    }
}