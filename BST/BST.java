package BST;

public class BST {
        class Node {
                int data;
                Node left;
                Node right;

                public Node(int data) {
                        this.data = data;
                        this.left = null;
                        this.right = null;
                }
        }

        public Node insert(Node root, int val) {
                if (root == null) {
                        root = new Node(val);
                        return root;
                }

                if (root.data > val) {
                        root.left = insert(root.left, val);
                } else {
                        root.right = insert(root.right, val);
                }

                return root;
        }

        public static void inorder(Node root) {
                if (root == null) {
                        return;
                }
                inorder(root.left);
                System.out.print(root.data + " ");
                inorder(root.right);
        }

        public static boolean searchInBST(Node root, int key) {
                if (root == null) {
                        return false;
                }
                if (root.data == key) {
                        return true;
                }

                if (key > root.data) {
                        return searchInBST(root.right, key);
                } else {
                        return searchInBST(root.left, key);
                }

        }

        public static Node deleteNode(Node root, int value) {
                if (root.data < value) {
                        root.right = deleteNode(root.right, value);
                } else if (root.data > value) {
                        root.left = deleteNode(root.left, value);
                }

                else {
                        // voila case
                        // case - 1 leaf node

                        if (root.left == null && root.right == null) {
                                return null;
                        }
                        // case - 2 single child

                        else if (root.left == null) {
                                return root.right;
                        } else if (root.right == null) {
                                return root.left;
                        }
                        // Case - 3 both children
                        Node IS = findInOrderSuccessor(root.right);
                        root.data = IS.data;
                        root.right = deleteNode(root.right, IS.data);
                }
                return root;

        }

        public static Node findInOrderSuccessor(Node root) {
                while (root.left != null) {
                        root = root.left;
                }
                return root;
        }

        public static void main(String[] args) {
                BST newBST = new BST();
                int nodes[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
                Node root = null;

                for (int i = 0; i < nodes.length; i++) {
                        root = newBST.insert(root, nodes[i]);
                }
                // newBST.inorder(root);
                // System.out.println();
                // System.out.println(newBST.searchInBST(root, 7));
                // System.out.println();
                root = deleteNode(root, 10);
                System.out.println();
                inorder(root);
        }
}
