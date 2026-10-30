class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount < 0) return -1;
        int[] coinsNeededFor = new int[amount+1];
        coinsNeededFor[0] = 0;
        for(int i = 1; i <= amount; i++){
            coinsNeededFor[i] = -1;
            for(int coin: coins){
                if(coin > i) break;
                if(coinsNeededFor[i] >= 0){
                    coinsNeededFor[i] = Math.min(coinsNeededFor[i], 1+coinsNeededFor[i-coin]);
                }else if(coinsNeededFor[i-coin] != -1){
                    coinsNeededFor[i] = 1 + coinsNeededFor[i-coin];
                }
            }
        }
        return coinsNeededFor[amount];
    }
}