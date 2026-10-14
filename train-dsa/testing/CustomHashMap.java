import java.util.Objects;

public class CustomHashMap<K,V> {
	private Node<K,V>[] buckets;
	private int capacity;
	
	@SuppressWarnings("unchecked")
    CustomHashMap(int capacity) {
		this.capacity = capacity;
		this.buckets = (Node<K,V>[]) new Node[capacity];
	}
	
	public V get(K key) {
		int index = getBucketIndex(key);
		Node<K,V> current = buckets[index];
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

	public void put(K key, V value) {
		int index = getBucketIndex(key);

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

    public int getBucketIndex(K key) {
        if(key == null) {
            return 0;
        }
        return (key.hashCode() & 0x7fffffff) % capacity;
    }
}

class Node<K,V> {

	private final K key;
	private V value;
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