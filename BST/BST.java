package BST;

import java.util.ArrayList;

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

        public static void printInRange(Node root, int k1, int k2) {
                if (root == null) {
                        return;
                }
                if (root.data <= k2 && root.data >= k1) {
                        printInRange(root.left, k1, k2);
                        System.out.print(root.data + " ");
                        printInRange(root.right, k1, k2);
                } else if (root.data <= k2) {
                        printInRange(root.right, k1, k2);
                } else {

                        printInRange(root.left, k1, k2);
                }
        }

        private static void printPath(ArrayList<Integer> path) {
                for (int i = 0; i < path.size(); i++) {
                        {
                                System.out.print(path.get(i) + "-");
                        }
                }
        }

        public static void printRootToLeafPath(Node root, ArrayList<Integer> path) {
                if (root == null) {
                        return;
                }
                path.add(root.data);
                if (root.left == null && root.right == null) {
                        printPath(path);
                        System.out.println();
                }
                printRootToLeafPath(root.left, path);
                printRootToLeafPath(root.right, path);
                path.remove(path.size() - 1);
        }

        public static void validateBst(Node root) {
                if (root == null) {
                        return;
                }
                ArrayList<Integer> list = new ArrayList<>();
                validateBst(root.left);
                list.add(root.data);
                System.out.print(root.data + " ");
                validateBst(root.right);

                // for (int i = 0; i < list.size(); i++) {
                //         System.out.print(list.get(i) + " ");
                // }
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
                // root = deleteNode(root, 10);
                // System.out.println();
                // inorder(root);
                // printInRange(root, 5, 10);
                // System.out.println();
                // printRootToLeafPath(root, new ArrayList<>());
                validateBst(root);
        }
}
