import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class Node {
        int key;
        int value;

        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map;

    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {

        this.capacity = capacity;
        this.map = new HashMap<>();

        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {

        Node node = map.get(key);

        if (node == null) {
            return -1;
        }

        remove(node);
        addToFront(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {

            Node existing = map.get(key);

            existing.value = value;

            remove(existing);
            addToFront(existing);

            return;
        }

        if (map.size() == capacity) {

            Node lru = tail.prev;

            remove(lru);
            map.remove(lru.key);
        }

        Node node = new Node(key, value);

        addToFront(node);
        map.put(key, node);
    }

    private void addToFront(Node node) {

        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    private void remove(Node node) {

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void printCache() {

        Node current = head.next;

        while (current != tail) {
            System.out.print("(" + current.key + "," + current.value + ") ");
            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(3);

        cache.put(1, 100);
        cache.put(2, 200);
        cache.put(3, 300);

        cache.printCache();

        cache.get(1);

        cache.printCache();

        cache.put(4, 400);

        cache.printCache();
    }
}