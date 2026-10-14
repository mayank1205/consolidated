import java.util.Objects;

public class CustomHashMap<K,V> {
    Node<K,V>[] buckets;
    int capacity;

    @SuppressWarnings("unchecked")
    CustomHashMap(int capacity) {
        this.capacity = capacity;
        this.buckets = (Node<K,V>[]) new Node[capacity];
    }

    public void put(K key, V value) {
        int index = getBucketIndex(key);
        if(buckets[index] != null) {
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
        } else {
            buckets[index] = new Node<K,V>(key, value);
        }
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        if(buckets[index] == null) {
            return null;
        }
        Node<K,V> current = buckets[index];
        while(current != null) {
            if(Objects.equals(current.getKey(), key)) {
                return current.getValue();
            }
            current = current.next;
        }
        return null;
    }

	private int getBucketIndex(K key) {
		if(key == null) {
            return 0;
        }
        return (key.hashCode() & 0x7fffffff) % capacity;
	}
}

class Node<K,V> {
    private K key;
    private V value;
    public Node<K,V> next;

    Node(K key, V value) {
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