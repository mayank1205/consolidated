import java.util.Map;
import java.util.HashMap;

public class LRUCache<K,V> {
    private final int capacity;

    private final Map<K, Node<K,V>> map;

    private Node<K,V> head;
    private Node<K,V> tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    public V get(K key) {
        if(!map.containsKey(key)) {
            return null;
        }
        Node<K,V> node = map.get(key);

        remove(node);

        addToFront(node);

        return node.value;
    }

    public void put(K key, V value) {
        if(map.containsKey(key)) {
            Node<K,V> node = map.get(key);
            node.value = value;

            remove(node);
            addToFront(node);
            return;
        }
        if(map.size() == capacity) {
            map.remove(tail.key);
            remove(tail);
        }
        Node<K,V> node = new Node<K,V>(key, value);
        addToFront(node);
        map.put(key, node);
    }

	private void addToFront(Node<K,V> node) {
		node.prev = null;
        node.next = head;
        if(head != null) {
            head.prev = node;
        }
        head = node;
        if(tail == null) {
            tail = node;
        }
	}

	private void remove(Node<K,V> node) {
        if(node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if(node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
	}

}

class Node<K,V> {
    K key;
    V value;
    Node<K,V> next;
    Node<K,V> prev;

    Node(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
