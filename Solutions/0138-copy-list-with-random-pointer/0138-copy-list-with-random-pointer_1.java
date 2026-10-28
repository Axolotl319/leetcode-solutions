/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        HashMap<Node, Node> originalToCopy = new HashMap<>(); // for randoms
        Node headCopy = new Node(head.val);
        originalToCopy.put(head, headCopy);
        Node curCopy = headCopy;
        Node next = head.next;
        while(next != null){
            Node nextCopy = new Node(next.val);
            curCopy.next = nextCopy;
            curCopy = curCopy.next;
            originalToCopy.put(next, curCopy);
            next = next.next;
        }
        // go back through and add randoms
        curCopy = headCopy;
        Node cur = head;
        while(cur != null){
            // use default because random can be null
            Node randomCopy = originalToCopy.getOrDefault(cur.random, null);
            curCopy.random = randomCopy;
            curCopy = curCopy.next;
            cur = cur.next;
        }
        return headCopy;
    }
}