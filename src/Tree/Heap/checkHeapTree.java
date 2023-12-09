package Tree.Heap;

import Tree.Node;

public class checkHeapTree {
    boolean isHeap(Node tree) {
        if (tree == null || numChild(tree)==0) {
            return true;
        }
        if (tree.left==null && tree.right!=null) return false;
        if (tree.left!=null && numChild(tree.left)==0 && tree.right==null) return true;
        if (tree.left!=null && tree.right==null) return false;
        if (numChild(tree.left)<2 && numChild(tree.right)>0) return false;
        if ((tree.left != null && tree.left.data > tree.data) ||
                (tree.right != null && tree.right.data > tree.data)) {
            return false;
        }
        return isHeap(tree.left) && isHeap(tree.right);
    }

    int numChild(Node node) {
        if (node==null) return 0;
        int count=0;
        if (node.left!=null) count++;
        if (node.right!=null) count++;
        return count;
    }
}
