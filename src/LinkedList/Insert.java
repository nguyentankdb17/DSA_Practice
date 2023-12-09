package LinkedList;

public class Insert {
    public Node insertHead(Node head, int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        return head;
    }

    public Node insertTail(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) head = newNode;
        Node tmp = head;
        while (tmp.next != null) tmp = tmp.next;
        tmp.next = newNode;
        return head;
    }

    public Node insertSpecific(Node head, int data, int position) {
        Node newNode = new Node(data);
        Node tmp = head;
        for (int i = 1; i < position; i++) {
            tmp = tmp.next;
        }
        newNode.next = tmp.next;
        tmp.next = newNode;
        return head;
    }
}
