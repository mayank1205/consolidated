public class CheckLinkListCycle<T> {
 public boolean checkLinkListCycle(Node<T> list) {
    if(list == null || list.next == null) {
        return false;
    }
    Node<T> slow = list;
    Node<T> fast = list;

    while(fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;

        if(slow == fast) {
            return true;
        }
    }
    return false;
 }   
}


class Node<T> {
    T data;
    Node<T> next;
}