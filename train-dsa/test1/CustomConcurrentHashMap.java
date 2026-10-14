public class CustomConcurrentHashMap<K,V> {
    
    Node<K,V>[] buckets;
    public Object[] locks;
    int capacity;

    CustomConcurrentHashMap(int capacity) {
        this.capacity = capacity;
        this.buckets = (Node<K,V>[]) new Node[capacity];
        locks = new Object[capacity];
        for (int i = 0; i < capacity; i++) {
            locks[i] = new Object();
        }
    }

    public void put(K key, V value) {
        
        int index = getBucketIndex(key);
        synchronized(locks[index]) {
            Node<K,V> node = buckets[index];
            if(node == null) {
                buckets[index] = new Node<K,V>(key, value);
                return;
            }
            Node<K,V> prev = node;
            while(node != null) {
                if(node.key.equals(key)) {
                    node.value = value;
                    return;
                }
                prev = node;
                node = node.next;
            }
            prev.next = new Node<K,V>(key, value);
        }
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        synchronized(locks[index]) {
            Node<K,V> node = buckets[index];

            while(node != null) {
                if(node.key.equals(key)) {
                    return node.value;
                }
                node = node.next;
            }
            return null;
        }

    }

    public int getBucketIndex(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }
}
