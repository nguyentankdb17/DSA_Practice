package Tree;

public class mirrorTree {
    void mirror(Node node) {
        // Your code here
        if (node==null) return;
        Node tmp = node.left;
        node.left = node.right;
        node.right = tmp;
        mirror(node.left);
        mirror(node.right);
    }
}
