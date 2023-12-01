package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Traversal {

    public static List<Integer> preOrder(Node root)
    {
        if(root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();

        res.add(root.data);
        res.addAll(preOrder(root.left));
        res.addAll(preOrder(root.right));

        return res;
    }

    public static List<Integer> inOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();

        res.addAll(inOrder(root.left));
        res.add(root.data);
        res.addAll(inOrder(root.right));

        return res;
    }

    public static List<Integer> postOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();

        res.addAll(postOrder(root.left));
        res.addAll(postOrder(root.right));
        res.add(root.data);

        return res;
    }

    public static List<Integer> levelOrder(Node root) {
        List<Integer> res = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        if(root != null){
            queue.add(root);
        }
        while(!queue.isEmpty()){
            Node p = queue.poll();
            res.add(p.data);
            if(p.left!=null) queue.add(p.left);
            if(p.right!=null) queue.add(p.right);
        }
        return res;
    }

    public static void main(String[] args) {

    }

}
