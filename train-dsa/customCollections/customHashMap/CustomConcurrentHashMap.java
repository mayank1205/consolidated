package customCollections.customHashMap;

public class CustomConcurrentHashMap<K,V> {

    private Node<K, V>[] buckets;
    private int capacity = 16;
    private final Object[] locks;

    public CustomConcurrentHashMap(int capacity) {
        this.capacity = capacity;
        this.buckets = new Node[capacity];
        locks = new Object[capacity];
        for (int i = 0; i < capacity; i++) {
            locks[i] = new Object();
        }
    }
    
    public void put(K key, V value) {
        int index = getBucketIndex(key);
        synchronized(locks[index]) {
            Node<K, V> head = buckets[index];
            while(head != null) {
                if(head.key.equals(key)) {
                    head.value = value;
                    return;
                }
                head = head.next;
            }
            Node<K, V> node = new Node<>(key, value);
            node.next = buckets[index];
            buckets[index] = node; 
        }       
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        synchronized(locks[index]) {
            Node<K, V> head = buckets[index];
            while(head != null) {
                if(head.key.equals(key)) {
                    return head.value;
                }
                head = head.next;
            }
        }
        return null;
    }

    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }
    
}
