package Tree.BST;

import Tree.Node;
import java.util.List;
import static Tree.Traversal.inOrder;

public class checkBST {
    boolean isBST(Node root)
    {
        List<Integer> res = inOrder(root);
        for (int i=0 ;i < res.size()-1;i++) {
            if (res.get(i) >= res.get(i+1)) return false;
        }
        return true;
    }
}
