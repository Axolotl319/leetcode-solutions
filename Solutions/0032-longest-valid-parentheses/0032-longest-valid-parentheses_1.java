class Solution {
    public int longestValidParentheses(String s) {
        int longest = 0;
        Stack<Character> brackets = new Stack<>();
        int currSize = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ')'){
                if(!brackets.isEmpty()){
                    brackets.pop();
                    currSize += 2;
                }else{
                    currSize = 0;
                }
            }else if(c == '('){
                brackets.push(c);
            }
            longest = Math.max(longest, currSize);
        }
        return longest;
    }
}