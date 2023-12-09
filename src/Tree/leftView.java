package Tree;

import java.util.ArrayList;

public class leftView {
    ArrayList<Integer> leftView(Node root) {
        // Your code here
        ArrayList<Integer> res = new ArrayList<>();
        if (root==null || (root.left==null && root.right==null)) return res;
        if (root.left!=null) res.add(root.left.data);
        if (root.left==null) {
            res.add(root.right.data);
            return leftView(root.right);
        }
        return leftView(root.left);
    }
}

