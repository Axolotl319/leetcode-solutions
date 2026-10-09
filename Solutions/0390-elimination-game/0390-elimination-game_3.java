class Solution {
    public int lastRemaining(int n) {
        int head = 1;
        boolean forward = true;
        int stepSize = 1; // needed to step over discarded elems
        int rem = n;
        while(rem > 1){
            if(forward || rem % 2 == 1) head += stepSize;
            rem /= 2;
            stepSize *= 2;
            forward = !forward;
        }
        return head;
    }
}