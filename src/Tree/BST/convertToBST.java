package Tree.BST;

import Tree.Node;

import java.util.PriorityQueue;
import java.util.Collections;

public class convertToBST {
    Node binaryTreeToBST(Node root)
    {
        PriorityQueue<Integer> pq = inOrder(root);
        convert(root, pq);
        return root;
    }

    void convert(Node root, PriorityQueue<Integer> pq) {
        if (root == null || pq.isEmpty()) return;

        convert(root.left, pq);
        root.data = pq.poll();
        convert(root.right, pq);
    }

    PriorityQueue<Integer> inOrder(Node root) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        if (root==null) {
            return pq;
        }

        pq.addAll(inOrder(root.left));
        pq.add(root.data);
        pq.addAll(inOrder(root.right));
        return pq;
    }
}
