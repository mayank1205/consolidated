public class CustomLinkList<T> {
    Node<T> head;

    CustomLinkList() {
        this.head = null;
    }

    public void add(Node<T> node) {
        if(this.head == null) {
            this.head = node;
        } else {
            Node<T> current = this.head;
            while(current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
    }
    public void remove() {
        Node<T> current = this.head;
        if(current == null) {
            return;
        }
        if(current.next == null) {
            this.head = null;
            return;
        }
        while(current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }
}

class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}