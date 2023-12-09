package LinkedList;

public class Merge {
    public Node mergeLinkedList(Node head1, Node head2) {
        if (head1==null) return head2;
        if (head2==null) return head1;

        Node res = new Node(-1);
        Node tmp = res;
        while (head1!=null && head2!=null) {
            if (head1.data < head2.data) {
                tmp.next = head1;
                head1 = head1.next;
            } else {
                tmp.next = head2;
                head2 = head2.next;
            }
            tmp = tmp.next;
        }
        if (head1==null) {
            tmp.next = head2;
        }
        if (head2==null) {
            tmp.next = head1;
        }
        return res.next;
    }
}
