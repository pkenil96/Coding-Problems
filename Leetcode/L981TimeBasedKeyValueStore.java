class L981TimeBasedKeyValueStore {

    /** Initialize your data structure here. */
    HashMap<String, TreeMap<Integer, String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)){
            TreeMap<Integer, String> inner = map.get(key);
            inner.put(timestamp, value);
            map.put(key, inner);
            return;
        } else {
            TreeMap<Integer, String> output = new TreeMap<>();
            output.put(timestamp, value);
            map.put(key, output);
            return;
        }
    }
    
    public String get(String key, int timestamp) {
        if(map.containsKey(key)){
            TreeMap<Integer, String> inner = map.get(key);
            if(inner.containsKey(timestamp)){
                return inner.get(timestamp);
            } else {
                String ans = "";
                Integer floor = inner.floorKey(timestamp);
                if(floor == null){
                    return "";
                }
                return inner.get(floor);
            }
        } else {
            return "";
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */