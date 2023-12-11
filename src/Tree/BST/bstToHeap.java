package Tree.BST;

import Tree.Node;

import java.util.PriorityQueue;

public class bstToHeap {
    static PriorityQueue<Integer> inOrder(Node root) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        if (root==null) {
            return pq;
        }
        pq.addAll(inOrder(root.left));
        pq.add(root.data);
        pq.addAll(inOrder(root.right));
        return pq;
    }

    public static void convertToMaxHeapUtil(Node root)
    {
        PriorityQueue<Integer> pq = inOrder(root);
        convert(root, pq);
    }

    static void convert(Node root, PriorityQueue<Integer> pq) {
        if (root == null || pq.isEmpty()) return;

        convert(root.left, pq);
        convert(root.right, pq);
        root.data = pq.poll();
    }
}
