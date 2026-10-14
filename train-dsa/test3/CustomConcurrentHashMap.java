public class CustomConcurrentHashMap<K,V> {
    private final Node<K,V>[] buckets;
    private final Object[] locks;
    private final int capacity;

    @SuppressWarnings("unchecked")
    public CustomConcurrentHashMap(int capacity) {
        this.capacity = capacity;
        this.buckets = (Node<K, V>[]) new Node[capacity];
        this.locks = new Object[capacity];
        for (int i = 0; i < capacity; i++) {
            locks[i] = new Object();
        }
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        synchronized(locks[index]) {
            if(buckets[index] != null) {
                Node<K,V> current = buckets[index];
                while(current != null) {
                    if(current.getKey().equals(key)) {
                        return current.getValue();
                    }
                    current = current.next;
                }
            }
            return null;
        }
    }

    public void put(K key, V value) {
        int index = getBucketIndex(key);
        synchronized(locks[index]) {
            if(buckets[index] != null) {
                Node<K,V> current = buckets[index];
                Node<K,V> prev = buckets[index];
                while(current != null) {
                    if(current.getKey().equals(key)) {
                        current.setValue(value);
                        return;
                    }
                    prev = current;
                    current = current.next;
                }
                prev.next = new Node<K,V>(key, value);
                return;
            }
            buckets[index] = new Node<K,V>(key, value);
        }
    }

	private int getBucketIndex(K key) {
		return Math.abs(key.hashCode()) % capacity;
	}
}

class Node<K,V> {
    private K key;
    private V value;
    public Node<K,V> next;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public K getKey() {
        return this.key;
    }
    public V getValue() {
        return this.value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
