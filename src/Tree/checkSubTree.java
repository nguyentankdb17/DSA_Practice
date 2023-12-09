package Tree;

public class checkSubTree {
    public static boolean isSubtree(Node T, Node S) {
        if (S == null)
            return true;

        if (T == null)
            return false;

        if (areIdentical(T, S))
            return true;

        return isSubtree(T.left, S) || isSubtree(T.right, S);
    }


    public static boolean areIdentical(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1==null || node2==null) {
            return false;
        }
        return (node1.data==node2.data) && areIdentical(node1.left,node2.left) && areIdentical(node1.right,node2.right);
    }
}
