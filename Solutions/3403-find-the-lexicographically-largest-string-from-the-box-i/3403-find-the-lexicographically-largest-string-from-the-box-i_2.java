class Solution {
    public String answerString(String word, int numFriends) {
        if(numFriends == 1) return word;
        // find largest partition size
        int size = word.length() + 1 - numFriends;
        System.out.println(size);

        // find lexicographically largest string of that size
        String largest = word.substring(0, size);
        for(int i = 0; i < word.length(); i++){
            int end = Math.min(i + size, word.length());
            String s = word.substring(i, end);
            if(s.compareTo(largest) > 0) largest = s;
        }

/*
        for(int i = 1; i <= word.length() - size; i++){
            System.out.println(largest);
            String s = word.substring(i, i+size);
            System.out.println(s);
            System.out.println(s.compareTo(largest));
            if(s.compareTo(largest) > 0) largest = s;
        }

        // check for a larger substring
        for(int i = 1; i < largest.length(); i++){
            String s = largest.substring(i);
            System.out.println(s);
            System.out.println(s.compareTo(largest));
            if(s.compareTo(largest) > 0) largest = s;
        }
*/
        return largest;
    }
}