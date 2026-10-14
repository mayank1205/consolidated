public class ReverseLinkList {
    Node reverse(Node head) {
        Node curr = head;
        Node prev = null;
        while(curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            
        }
        return prev;
    }
    public static void main(String[] args) {
        System.out.println("hello");
    }

}

public boolean hasCycle(Node head) {
    Node slow = head;
    Node fast = head;
    while(fast != null && fast.next != null) {
        if(fast == slow) {
            return true;
        }
        slow = slow.next;
        fast = fast.next.next;
    }
    return false;

}

class Node {
    int data;
    Node next;
}