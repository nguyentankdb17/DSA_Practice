package Tree;

public class checkSumTree {
    boolean isSumTree(Node root)
    {
        if (root==null || (root.left == null && root.right == null)) return true;
        return (root.data == sum(root.left) + sum(root.right)) && isSumTree(root.left) && isSumTree(root.right);
    }

    int sum(Node root) {
        if (root==null) return 0;
        return sum(root.left) + sum(root.right) + root.data;
    }
}
