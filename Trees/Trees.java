
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

                public static int heightOfTree(Node root) {
                        if (root == null) {
                                return -1;
                        }

                        int leftHeight = heightOfTree(root.left);
                        int rightHeight = heightOfTree(root.right);

                        int maxHeight = 1 + Math.max(leftHeight, rightHeight);

                        return maxHeight;
                }

                public static int noOfNodesInATree(Node root) {
                        if (root == null) {
                                return 0;
                        }

                        int leftCount = noOfNodesInATree(root.left);
                        int rightCount = noOfNodesInATree(root.right);

                        return leftCount + rightCount + 1;
                }

                public static int sumOfNodes(Node root) {
                        if (root == null) {
                                return 0;
                        }
                        int leftSum = sumOfNodes(root.left);
                        int rightSum = sumOfNodes(root.right);

                        return rightSum + leftSum + root.data;
                }

                public static boolean isIdentical(Node node, Node subRoot) {
                        if (node == null && subRoot == null) {
                                return true;
                        } else if (node == null || subRoot == null || node.data != subRoot.data) {
                                return false;
                        }

                        if (!isIdentical(node.left, subRoot.left)) {
                                return false;
                        }

                        if (!isIdentical(node.right, subRoot.right)) {
                                return false;
                        }

                        return true;

                }

                public static boolean isSubTree(Node root, Node subRoot) {
                        if (root == null) {
                                return false;
                        }
                        if (root.data == subRoot.data) {
                                if (isIdentical(root, subRoot)) {
                                        return true;
                                }
                        }

                        return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
                }
        }

        public static void main(String[] args) {
                int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

                BinaryTree tree = new BinaryTree();
                Node ans = tree.buildTree(nodes);
                tree.preorder(ans);
                System.out.println();
                tree.inorder(ans);
                System.out.println();
                tree.postOrder(ans);
                System.out.println();
                tree.levelOrder(ans);

                int maxHeight = tree.heightOfTree(ans);
                System.out.println(maxHeight);
                int numberOfTotalNodesInATree = tree.noOfNodesInATree(ans);
                System.out.println(numberOfTotalNodesInATree);

                int totalSum = tree.sumOfNodes(ans);
                System.out.println(totalSum);

                Node root = new Node(1);
                root.left = new Node(2);
                root.right = new Node(3);
                root.left.left = new Node(4);
                root.left.right = new Node(5);
                root.right.right = new Node(6);
                // System.out.print(ans.data);

                Node subroot = new Node(2);
                subroot.left = new Node(4);
                subroot.right = new Node(5);

                System.out.println(tree.isSubTree(root, subroot));
        }
}
