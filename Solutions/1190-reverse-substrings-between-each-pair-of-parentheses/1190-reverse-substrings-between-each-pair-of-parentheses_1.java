class Solution {
    public String reverseSubstring(String s, int i, int j){
        String start = s.substring(0, i);
        String middle = s.substring(i, j);
        String end = s.substring(j);
        StringBuilder sb = new StringBuilder();
        for(int k = middle.length() - 1; k >= 0; k--){
            sb.append(middle.charAt(k));
        }
        return start + sb.toString() + end;
    }

    public String reverseParentheses(String s) {
        Stack<Integer> openBracketIndexes = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                openBracketIndexes.push(i);
            }else if(c == ')'){
                int start = openBracketIndexes.pop();
                s = reverseSubstring(s, start, i+1);
            }
        }
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c != '(' && c != ')'){
                sb.append(c);
            }
        }
        return sb.toString();
        
    }
}