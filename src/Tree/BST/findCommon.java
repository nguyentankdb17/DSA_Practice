package Tree.BST;

import Tree.Node;

import java.util.ArrayList;
import java.util.Collections;

public class findCommon {
    public static ArrayList<Integer> findCommon(Node root1, Node root2)
    {
        ArrayList<Integer> l1 = inOrder(root1);
        ArrayList<Integer> l2 = inOrder(root2);
        l1.retainAll(l2);
        Collections.sort(l1);
        return l1;
    }

    static ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root==null) return res;

        res.addAll(inOrder(root.left));
        res.add(root.data);
        res.addAll(inOrder(root.right));
        return res;
    }
}
