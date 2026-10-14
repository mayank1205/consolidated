public class CustomLinkListFinal<K,V> {
    Node<K,V> head;
    Node<K,V> tail;

    public void addToFront(Node<K,V> node) {
        node.next = head.next;
        head = node;

        if(tail == null) {
            tail = node;
        }
    }

    public void addToBack(Node<K,V> node) {
        if(head == null) {
            head = tail = node;
            return;
        } 
        tail.next = node;
        tail = node;
    }

    public void removeFromFront() {

        if(head == null) {
            return;
        }
        head = head.next;
        if(head == null) {
            tail = null;
        }

    }

    public void removeFromBack() {
        
        if(head == null) {
            return;
        }

        if(head == tail) {
            head = tail = null;
            return;
        }
        
        Node<K,V> current = head;
        while(current.next != tail) {
            current = current.next;
        }
        current.next = null;
            tail = current;
    }

    public void removeFromIndex(int element) {
        if(head == null) {
            return;
        }
        if(element == 0) {
            removeFromFront();
            return;
        }
        int index = 0;
        Node<K,V> prev = head;
        while(prev.next != null) {
            if(index == element -1) {
                
                Node<K,V> current = prev.next;
                if(current == tail) {
                    tail = prev;
                }
                prev.next = current.next;
                current.next = null;
                return;
            }
            prev = prev.next;
            index++;
        }
    }
}
