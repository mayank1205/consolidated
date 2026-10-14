import java.util.Objects;

public class CustomHashMap<K,V> {
    Node<K,V> buckets[];
    int capacity;

    @SuppressWarnings("unchecked")
	CustomHashMap(int capacity) {
        this.capacity = capacity;
        this.buckets = (Node<K,V>[]) new Node[capacity];
    }

    public void put(K key, V value) {
        int index = getBucketIndex(key);
        Node<K,V> node = buckets[index];
        if(node == null) {
            buckets[index] = new Node<K,V>(key, value);
            return;
        } else {
            Node<K,V> prev = node;
            while(node != null) {
                if(Objects.equals(node.getKey(), key)) {
                    node.setValue(value);
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
        Node<K,V> node = buckets[index];
        while(node != null) {
            if(Objects.equals(node.getKey(), key)) {
                return node.getValue();
            }
            node = node.next;
        }
        return null;
    }

	private int getBucketIndex(K key) {
		return Math.abs(key.hashCode()) % capacity;
	}
}
