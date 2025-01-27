class LRUCache {
    private static int size;
    private static HashMap<Integer, Integer> map;

    // Constructor for initializing the cache capacity with the given value.
    LRUCache(int cap) {
        this.size = cap;
        this.map = new LinkedHashMap<>();
    }

    // Function to return value corresponding to the key.
    public static int get(int key) {
        if (!map.containsKey(key)) return -1;
        int value = map.get(key);
        // Move the accessed key to the end to mark it as recently used
        map.remove(key);
        map.put(key, value);
        return value;
    }

    // Function for storing key-value pair.
    public static void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
        } else if (map.size() == size) {
            Integer firstKey = map.keySet().iterator().next();
            map.remove(firstKey);
        }
        map.put(key, value);
    }
}
