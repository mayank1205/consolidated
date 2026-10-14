import java.util.Objects;

public class CustomConcurrentHashMap<K,V> {
	private Node<K,V>[] buckets;
	private final int capacity;
    private Object[] locks;
	
	@SuppressWarnings("unchecked")
    CustomConcurrentHashMap(int capacity) {
		this.capacity = capacity;
		this.buckets = (Node<K,V>[]) new Node[capacity];
        this.locks = new Object[capacity];
        for(int i = 0; i< capacity; i++) {
            this.locks[i] = new Object();
        }
	}
	
	public V get(K key) {
		int index = getBucketIndex(key);
		Node<K,V> current = buckets[index];
		synchronized (locks[index]) {
            if(current != null) {
                while(current != null) {
                    if(Objects.equals(current.getKey(), key)) {
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

		synchronized (locks[index]) {
            if(buckets[index] == null) {
                buckets[index] = new Node<K,V>(key, value);
            } else {
                Node<K,V> current = buckets[index];
                Node<K,V> prev = buckets[index];
                while(current != null) {
                    if(Objects.equals(current.getKey(), key)) {
                        current.setValue(value);
                        return;
                    }
                    prev = current;
                    current = current.next;
                }
                prev.next = new Node<K,V>(key, value);
            }
        }
	}

    public int getBucketIndex(K key) {
        if(key == null) {
            return 0;
        }
        return (key.hashCode() & 0x7fffffff) % capacity;
    }
}

class Node<K,V> {

	private final K key;
	private volatile V value;
	public Node<K,V> next;

	public Node(K key, V value) {
		this.key = key;
		this.value = value;
		this.next = null;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}
	
	public void setValue(V value) {
		this.value = value;
	}

}