public class CheckCyclicLinkList {
    public static void main(String[] args) {
        Node<Integer> node = new Node<>(10);
        node.next = new Node<>(20);
        node.next.next = new Node<>(30);
        node.next.next.next = new Node<>(40);
        node.next.next.next.next = new Node<>(50);

        boolean isCyclic = checkCyclicList(node);

        if(isCyclic) {
            System.out.println("is cyclic link list");
        } else {
            System.out.println("is not cyclic link list");
        }
    }

	private static boolean checkCyclicList(Node<Integer> node) {
		if (node == null) return false;
        Node<Integer> slow = node;
        Node<Integer> fast = node.next;

        while(fast != null && fast.next != null) {

            if(slow == fast) {
                return true;
            }
            
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
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