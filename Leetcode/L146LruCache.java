class L146LRUCache {
    
    /*
        -We use a linkedhashset which acts like a set that preserves the insertion order. New items are added to the end of the queue and 
        items are removed from the front of the queue. Front of the queue points to the least recently used page while the rear of the queue
        points to the page that is most recently used.
        -Whenever we update the cache, we can have two cases: 1) The cache is not full and we can simply add the item to the end of the
        queue and add that page in the map. 2) The cache is full and we need to remove some items using LRU eviction policy. In that case
        we remove the item from the front of the queue. And then add the new item at the end.

        Cache Hit: The page being asked for is present in the cache. In such case, we simply return th page value and bring that page
        in the end of the queue.
        Cache Miss: The page being asked for is absent in the cache. In such case, we return -1
    */
    
    
    static int capacity;
    static HashMap<Integer, Integer> cacheMap;
    static LinkedHashSet<Integer> cache;
    
    public LRUCache(int capacity) {
        
        this.capacity = capacity;
        /*
            Why use HashMap?
            Everytime a page is found in the cache, we need the value corresponding to it, so we store this mapping in the hashmap
        */
        cacheMap = new HashMap<>();
        /*
            Why use LinkedHashSet?
            Everytime a page is accessed(get), it needs to be brought to the front of the queue. The why not use just queue? Because
            we also need O(1) lookup. Whenever, a get(key) call is made, we first need to check if the page exists in the cache or not.
            So, we need a set for O(1) lookup. In case the page does not exists, we simply return -1. However, if the page exists, we
            not only return the page value but also increase the priority of that page by bringing it in the front of the set. Normal set
            does not preserve insertion order. However, LinkedHashSet in java preserves the insertion order.
        */
        cache = new LinkedHashSet<>();
        
    }
    
    public int get(int key) {
        if(!cache.contains(key)){
            return -1;
        }
        cache.remove(key);
        cache.add(key);
        return cacheMap.get(key);
    }
    
    public void put(int key, int value) {
        // item already present in the cache, we just need to bring it in the front of the queue
        if(cache.contains(key)){
            cache.remove(key);
            cache.add(key);
            cacheMap.put(key, value);
            return;
        } else {
            // in case page is missing and cache is full, we do eviction
            if(cache.size() == capacity){
                // least recently used item would be at the front of the queue
                int leastRecentlyUsedItem = cache.iterator().next();
                cache.remove(leastRecentlyUsedItem);
                cache.add(key);
                cacheMap.put(key, value);
                return;
            } else {
                cache.add(key);
                cacheMap.put(key, value);
                return;
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */