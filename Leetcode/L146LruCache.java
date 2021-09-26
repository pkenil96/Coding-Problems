class L146LRUCache {
    
    LinkedHashSet<Integer> cache;
    HashMap<Integer, Integer> map;
    int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new LinkedHashSet<>();
    }
    
    public int get(int key) {
        if(cache.contains(key)){
            cache.remove(key);
            cache.add(key);
            return map.get(key);
        }
        return -1;
    }
    
    private void handleCacheHit(int key, int value){
        // we simply need to bring key at the tail of the queue
        cache.remove(key);
        cache.add(key);
        map.put(key, value);
    }
    
    private  void handleCacheMiss(int key, int value){
        // in case the cache is full, we need to remove elements
        // based on the LRU policy before adding the new key
        if(cache.size() == capacity){
            // we need to remove the least recently used item
            // the least recently used item would lie at the front of the queue
            int leastRecentlyUsedItem = cache.iterator().next();
            cache.remove(leastRecentlyUsedItem);
            map.remove(leastRecentlyUsedItem);
            cache.add(key);
            map.put(key, value);
        } else {
            cache.add(key);
            map.put(key, value);
        }
    }
    
    public void put(int key, int value) {
        if(cache.contains(key)){
            handleCacheHit(key, value);
        } else {
            handleCacheMiss(key, value);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */