public class CustomHashMap<K,V> {
    
    Node<K,V>[] buckets;
    int capacity;

    CustomHashMap(int capacity) {
        this.capacity = capacity;
        this.buckets = new Node<K,V>[capacity];
    }

    public void put(K key, V value) {
        
        int index = getBucketIndex(key);
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

    public V get(K key) {
        int index = getBucketIndex(key);
        Node<K,V> node = buckets[index];

        while(node != null) {
            if(node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;

    }

    public int getBucketIndex(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }
}
