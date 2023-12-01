package Tree.BST;

import Tree.Node;

public class insertNode {
    public static Node insert(Node root, int data) {
        if (root==null) {
            return new Node(data);
        }
        else {
            Node curr;
            if (data < root.data) {
                curr = insert(root.left,data);
                root.left = curr;
            }
            else {
                curr = insert(root.right,data);
                root.right = curr;
            }
            return root;
        }
    }
}
