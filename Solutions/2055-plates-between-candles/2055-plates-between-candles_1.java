class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = queries.length;
        int[] answer = new int[n];
        for(int i = 0; i < n; i++){
            int[] query = queries[i];
            answer[i] = 0;
            Stack<Character> platesAndCandles = new Stack<>();
            String str = s.substring(query[0], query[1]+1);
            for(int j = 0; j < str.length(); j++){
                if(str.charAt(j) == '|'){
                    // candle
                    while(!platesAndCandles.isEmpty()){
                        char c = platesAndCandles.pop();
                        if(c == '*') answer[i]++;
                    }
                    platesAndCandles.push(str.charAt(j));
                }else if(!platesAndCandles.isEmpty()){
                    // currently in between candles
                    platesAndCandles.push(str.charAt(j));
                }
            }
        }
        return answer;
    }
}