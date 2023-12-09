package LinkedList;

public class checkCircular {
    public boolean isCircular(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
