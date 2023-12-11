package Tree.BST;

import Tree.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class kthLargestInBST {
    public int kthLargest(Node root,int k)
    {
        //Your code here
        List<Integer> list = inOrder(root);
        Collections.sort(list);
        return list.get(list.size()-k);
    }

    List<Integer> inOrder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root==null) return res;
        res.addAll(inOrder(root.left));
        res.add(root.data);
        res.addAll(inOrder(root.right));
        return res;
    }
}
