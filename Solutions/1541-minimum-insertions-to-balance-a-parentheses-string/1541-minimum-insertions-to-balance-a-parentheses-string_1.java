class Solution {
    public int minInsertions(String s) {
        Stack<Character> lefts = new Stack<>();
        int insertions = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                lefts.push(c);
            }else if(c == ')' && i < s.length()-1 && s.charAt(i+1) == ')'){
                if(lefts.isEmpty()){
                    insertions++;
                }else{
                    lefts.pop();
                }
                i++; // skip over next )
            }else{
                // a single )
                insertions++;
                if(lefts.isEmpty()){
                    insertions++;
                }else{
                    lefts.pop();
                }
            }
        }

        while(!lefts.isEmpty()){
            insertions += 2; // 2 more right brackets needed
            lefts.pop();
        }

        return insertions;
    }
}