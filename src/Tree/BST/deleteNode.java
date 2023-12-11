package Tree.BST;

import Tree.Node;

public class deleteNode {
    public Node deleteNode(Node root, int key) {
        if (root == null) {
            return null;
        }
        // Find where to delete
        if (key < root.data) {
            deleteNode(root.left, key);
            return root;
        } else if (key > root.data) {
            deleteNode(root.right, key);
            return root;

        // Handle when found the node to delete
        } else {
            //If a children is null
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // When both children not null
            else {
                Node succParent = root;

                Node succ = root.right;
                while (succ.left != null) {
                    succParent = succ;
                    succ = succ.left;
                }

                if (succParent != root) {
                    succParent.left = succ.right;
                } else {
                    succParent.right = succ.right;
                }

                root.data = succ.data;
                return root;
            }
        }
    }
}
