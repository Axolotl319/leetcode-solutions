class Solution {
    public int scoreOfParentheses(String s) {
        // precondition: s is balanced
        int score = 0;
        int nextScore = 0;
        Stack<Character> brackets = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                if(brackets.isEmpty()){
                    if(score == 0){
                        score++;
                    }else{
                        nextScore++;
                    }
                }else{
                    score *= 2;
                }
                brackets.push(c);
            }else if(c == ')'){
                // only other case, condition just for clarity
                brackets.pop();
                if(brackets.isEmpty()){
                    score += nextScore;
                    nextScore = 0;
                }
            }
        }
        return score;
    }
}