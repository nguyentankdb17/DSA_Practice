package Tree;

public class checkBalanced {
    static boolean isBalanced(Node root)
    {
        if (root==null) return true;
        if (Math.abs(height(root.left) - height(root.right)) > 1) return false;
        return (isBalanced(root.left) && isBalanced(root.right));
    }

    static int height(Node root) {
        if (root==null) return 0;
        return Math.max(height(root.left),height(root.right)) +1;
    }
}
