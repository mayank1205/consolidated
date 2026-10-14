public class CustomHashMap<K,V> {
    Node<K,V>[] buckets;
    int capacity;

    CustomHashMap(int capacity) {
        this.buckets = new Node[capacity];
        this.capacity = capacity;
    }

    public void put(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        if(buckets[bucketIndex] != null) {
            Node<K,V> node = buckets[bucketIndex];
            Node<K,V> newNode = new Node<K,V>(key, value);
            while(node != null) {
                if(node.key.equals(key)) {
                    node.value = value;
                    return;
                }
                if(node.next == null) {
                    break;
                }
                node = node.next;
            }
            node.next = newNode;
        } else {
            Node<K,V> newNode = new Node<K,V>(key, value);
            buckets[bucketIndex] = newNode;
        }
    }

    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        if(buckets[bucketIndex] == null) {
            return null;
        } else {
            Node<K,V> node = buckets[bucketIndex];

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