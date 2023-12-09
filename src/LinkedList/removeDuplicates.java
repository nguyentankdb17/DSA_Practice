package LinkedList;

public class removeDuplicates {
    Node deleteDuplicates(Node head)
    {
        // Your code here
        Node tmp = head;
        while (tmp!=null && tmp.next!=null) {
            if (tmp.data == tmp.next.data) {
                tmp.next = tmp.next.next;
            }
            else tmp = tmp.next;
        }
        return head;
    }
}
