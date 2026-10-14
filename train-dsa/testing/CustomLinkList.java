public class CustomLinkList<T> {
    private Node<T> head;
    private Node<T> tail;

    public void addToFront(T data) {
        Node<T> node = new Node<T>(data);
        if(head == null) {
            head = node;
            tail = node;
            return;
        }
        node.next = head;
        head = node;
    }

    public void addToBack(T data) {
        Node<T> node = new Node<T>(data);
        if(tail == null) {
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        tail = node;
    }

    public void removeFromFront() {
        if(head == null){
            return;
        }
        if(head.next == null) {
            head = null;
            tail = null;
            return;
        }
        head = head.next;
    }


    public void removeFromBack() {
        if(head == null){
            return;
        }
        if (head.next == null) {
            head = null;
            tail = null;
            return;
        }
        Node<T> current = head;
        while(current.next != tail) {
            current = current.next;
        }
        current.next = null;
        tail = current;
    }
}

class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }
        
}