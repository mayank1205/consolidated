package customCollections.customLinkedList;

public class CustomLinkedList<T> {
    Node<T> head;

    public void add(T data) {
        Node<T> newNode = new Node<T>(data);
        if(head == null) {
            head = newNode;
            return;
        }
        head.next = newNode;
        Node<T> currNode = head;
        while(currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    public void print() {
        Node<T> current = head;
        
        while (current.next != null) {
            System.out.println(current.data + " ");
        }
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
