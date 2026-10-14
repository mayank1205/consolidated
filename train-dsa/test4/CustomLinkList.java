public class CustomLinkList<T> {
    Node<T> head;
    Node<T> tail;

    public void addToFront(Node<T> newNode) {
        if(head == null) {
            head = newNode;
            tail = newNode;
        }
        else if(head != null) {
            newNode.next = head;
            head = newNode;
        }
    }

    public void addToBack(Node<T> newNode) {
        if(head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void removeFromFront() {
        if(head == null) {
            return;
        }
        if (head.next == null) {
            head = null;
            tail = null;
            return;
        }
        head = head.next;
    }

    public void removeFromBack() {
         if(head == null) {
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