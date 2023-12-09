package LinkedList;

public class Delete {
    public Node deleteHead(Node head) {
        return head.next;
    }

    public Node deleteTail(Node head) {
        Node tmp = head;
        while (tmp.next.next != null) tmp = tmp.next;
        tmp.next = null;
        return head;
    }

    public Node deleteSpecific(Node head, int position) {
        if (position == 0) {
            return head.next;
        }
        Node tmp = head;
        for (int i = 1; i < position; i++) {
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
        return head;
    }
}
