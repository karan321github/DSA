
import java.util.*;

class HelloWorld {
        static class Node {
                int data;
                Node left;
                Node right;

                public Node(int data) {
                        this.data = data;
                        this.left = null;
                        this.right = null;
                }
        }

        static class BinaryTree {
                static int i = -1;

                public static Node buildTree(int nodes[]) {
                        i++;

                        if (nodes[i] == -1) {
                                return null;
                        }

                        Node root = new Node(nodes[i]);
                        root.left = buildTree(nodes);
                        root.right = buildTree(nodes);

                        return root;
                }

                public static void preorder(Node root) {
                        if (root == null) {
                                System.out.print(-1 + " ");
                                return;
                        }
                        System.out.print(root.data + " ");
                        preorder(root.left);
                        preorder(root.right);
                }

                public static void inorder(Node root) {

                        if (root == null) {
                                return;
                        }
                        inorder(root.left);
                        System.out.print(root.data + " ");
                        inorder(root.right);
                }

                public static void postOrder(Node root) {

                        if (root == null) {
                                return;
                        }

                        postOrder(root.left);
                        postOrder(root.right);
                        System.out.print(root.data + " ");
                }

                public static void levelOrder(Node root) {
                        if (root == null) {
                                return;
                        }
                        Queue<Node> q = new LinkedList<>();
                        q.add(root);
                        q.add(null);

                        while (!q.isEmpty()) {
                                Node currNode = q.remove();
                                if (currNode == null) {
                                        System.out.println();
                                        if (q.isEmpty()) {
                                                break;
                                        } else {
                                                q.add(null);
                                        }
                                } else {
                                        System.out.print(currNode.data + " ");
                                        if (currNode.left != null) {
                                                q.add(currNode.left);
                                        }
                                        if (currNode.right != null) {
                                                q.add(currNode.right);
                                        }
                                }

                        }
                }
        }

        public static void main(String[] args) {
                int nodes[] = { 8, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

                BinaryTree tree = new BinaryTree();
                Node ans = tree.buildTree(nodes);
                tree.preorder(ans);
                System.out.println();
                tree.inorder(ans);
                System.out.println();
                tree.postOrder(ans);
                System.out.println();
                ;
                tree.levelOrder(ans);

                // System.out.print(ans.data);

        }
}
