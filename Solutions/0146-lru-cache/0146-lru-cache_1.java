class LRUCache {

    private int cap;
    private List<Integer> keys; // ordered by time of last use
    private Map<Integer, Integer> buckets;

    public LRUCache(int capacity) {
        if(capacity <= 0) throw new Error("capacity must be positive");
        this.cap = capacity;
        this.keys = new ArrayList<>();
        this.buckets = new HashMap<>();
    }
    
    public int get(int key) {
        if(keys.contains(key)){
            // reinsert at end to indicate recent use
            keys.remove((Integer) key); // type cast to object so removes elem not at index
            keys.add(key);
            return buckets.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(keys.contains(key)){
            keys.remove((Integer) key);
        }
        keys.add(key); // insert at end to indicate recent use
        if(keys.size() > cap){
            keys.remove(keys.get(0)); // least recently used
        }
        buckets.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */