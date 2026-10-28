class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = queries.length;
        int[] answer = new int[n];

        // first locate all candles in s
        List<Integer> candles = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '|'){
                candles.add(i);
            }
        }

        for(int i = 0; i < n; i++){
            int[] query = queries[i];
            if(query[0] >= query[1]) continue;
            int j = 0; int k = candles.size()-1;
            while(candles.get(j) < query[0]) j++;
            while(candles.get(k) > query[1]) k--;
            // there are (k + 1 - j) candles in the substring
            // candles[j] and candles[k] are the first and last
            answer[i] = Math.max(candles.get(k) - candles.get(j) - (k - j), 0);
        }

/*
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
        }*/
        return answer;
    }
}