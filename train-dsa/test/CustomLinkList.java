public class CustomLinkList<K,V> {
    Node<K,V> head = null;
    Node<K,V> tail = null;

    public void addToFront(Node<K,V> node) {
        node.next = head;
        head = node;

        if (tail == null) {
            tail = node;
        }
    }
    
    public void addToBack(Node<K,V> node) {

        if (head == null) {
            head = tail = node;
            return;
        }

        tail.next = node;
        tail = node;
    }

    public void removeFromFront() {
        head = head.next;
        if (head == null) {
            tail = null;
        }
    }
    
    public void removeFromBack() {

        if (head == null) {
            return;
        }

        if (head == tail) {
            head = tail = null;
            return;
        }

        Node<K,V> current = head;

        while (current.next != tail) {
            current = current.next;
        }

        current.next = null;
        tail = current;
    }

}