
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

                static class Info {
                        Node node;
                        int hd;

                        public Info(Node node, int hd) {
                                this.node = node;
                                this.hd = hd;
                        }
                }

                public static void topView(Node root) {
                        Queue<Info> q = new LinkedList<>();
                        HashMap<Integer, Node> map = new HashMap<>();
                        int min = 0;
                        int max = 0;
                        q.add(new Info(root, 0));
                        q.add(null);
                        while (!q.isEmpty()) {
                                Info currInfo = q.remove();
                                if (currInfo == null) {
                                        if (q.isEmpty()) {

                                                break;
                                        } else {

                                                q.add(null);
                                        }
                                } else {
                                        if (!map.containsKey(currInfo.hd)) {
                                                map.put(currInfo.hd, currInfo.node);
                                        }
                                        if (currInfo.node.left != null) {
                                                q.add(new Info(currInfo.node.left, currInfo.hd - 1));
                                                min = Math.min(min, currInfo.hd - 1);
                                        }

                                        if (currInfo.node.right != null) {
                                                q.add(new Info(currInfo.node.right, currInfo.hd + 1));
                                                max = Math.max(max, currInfo.hd + 1);
                                        }
                                }

                        }
                        for (int i = min; i <= max; i++) {
                                System.out.print(map.get(i).data + " ");
                        }
                        System.out.println();
                }

                public static void kthLevel(Node root, int level, int k) {
                        if (root == null) {
                                return;
                        }
                        if (level == k) {
                                System.out.print(root.data + " ");
                                return;
                        }

                        kthLevel(root.left, level + 1, k);
                        kthLevel(root.right, level + 1, k);
                }

                public static void KthLevelIterative(Node root, int k) {
                        int level = 1;
                        Queue<Node> q = new LinkedList<>();
                        q.add(root);
                        q.add(null);

                        while (!q.isEmpty()) {
                                Node currNode = q.remove();
                                if (currNode == null) {
                                        System.out.println();
                                        level++;
                                        if (q.isEmpty()) {
                                                break;
                                        } else {
                                                q.add(null);
                                        }
                                } else {
                                        if (level == k)
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

                public static boolean getPath(Node root, int n, ArrayList<Node> path) {
                        if (root == null) {
                                return false;
                        }
                        path.add(root);
                        if (root.data == n) {
                                return true;
                        }

                        boolean leftFound = getPath(root.left, n, path);
                        boolean rightFound = getPath(root.right, n, path);

                        if (leftFound || rightFound) {
                                return true;
                        }

                        path.remove(path.size() - 1);
                        return false;
                }

                public static Node lca(Node root, int n1, int n2) {
                        ArrayList<Node> path1 = new ArrayList<>();
                        ArrayList<Node> path2 = new ArrayList<>();

                        getPath(root, n1, path1);
                        getPath(root, n2, path2);
                        int i = 0;
                        for (; i < path1.size() && i < path2.size(); i++) {
                                if (path1.get(i) != path2.get(i)) {
                                        break;
                                }
                        }

                        Node lca = path1.get(i - 1);
                        return lca;
                }

                public static int lcaDist(Node root, int n) {
                        if (root == null) {
                                return -1;
                        }

                        if (root.data == n) {
                                return 0;
                        }

                        int leftDistance = lcaDist(root.left, n);
                        int rightDistance = lcaDist(root.right, n);

                        if (leftDistance == -1 && rightDistance == -1) {
                                return -1;
                        } else if (leftDistance == -1) {
                                return rightDistance + 1;
                        } else {
                                return leftDistance + 1;
                        }
                }

                public static int minDistanceBetweenTwoNodes(Node root, int n1, int n2) {
                        Node lca = lca(root, n1, n2);

                        int dist1 = lcaDist(lca, n1);
                        int dist2 = lcaDist(lca, n2);

                        return dist1 + dist2;
                }

                public static int KthAnccestor(Node root, int n, int k) {
                        if (root == null) {
                                return -1;
                        }
                        if (root.data == n) {
                                return 0;
                        }

                        int leftDist = KthAnccestor(root.left, n, k);
                        int rightist = KthAnccestor(root.right, n, k);

                        if (leftDist == -1 && rightist == -1) {
                                return -1;
                        }

                        int max = Math.max(leftDist, rightist);

                        if (max + 1 == k) {
                                System.out.println(root.data);
                        }

                        return max + 1;

                }

                public static boolean helper(Node l, Node r) {
                        if (l == null && r == null) {
                                return true;
                        }
                        if (l == null || r == null) {
                                return false;
                        }

                        boolean isDataSame = l.data == r.data;
                        boolean isSymmetric1 = helper(l.left, r.right);
                        boolean isSymmetric2 = helper(l.right, r.left);

                        return isDataSame && isSymmetric1 && isSymmetric2;

                }

                public static boolean isSymmetric(Node root) {
                        if (root == null) {
                                return true;
                        }

                        return helper(root.left, root.right);
                }

                public static int diameter(Node root) {
                        if (root == null) {
                                return 0;
                        }
                        int leftDiam = diameter(root.left);
                        int rightDiam = diameter(root.right);
                        int leftHeight = heightOfTree(root.left);
                        int rightHeight = heightOfTree(root.left);

                        int throughRoot = leftHeight + rightHeight + 1;
                        int maxDiameter = Math.max(throughRoot, Math.max(rightDiam, leftDiam));

                        return maxDiameter;
                }

                public static Node buildBinarySearchTree(int[] nodes) {
                        i++;
                        Node root = new Node(i);
                        if (nodes[i] < root.data) {
                                root.left = buildBinarySearchTree(nodes);
                        } else {
                                root.right = buildBinarySearchTree(nodes);
                        }

                        return root;
                }

        }

        public static void main(String[] args) {
                BinaryTree tree = new BinaryTree();
                Node root = new Node(1);
                root.left = new Node(2);
                root.left.left = new Node(3);
                root.left.right = new Node(4);
                root.right = new Node(2);
                root.right.right = new Node(3);
                root.right.left = new Node(4);
                // System.out.println(tree.isSymmetric(root));
                System.out.println(tree.noOfNodesInATree(root));
                // int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
                // Node ans = tree.buildTree(nodes);
                // tree.preorder(ans);
                // System.out.println();
                // tree.inorder(ans);
                // System.out.println();
                // tree.postOrder(ans);
                // System.out.println();
                // tree.levelOrder(ans);
                // int maxHeight = tree.heightOfTree(ans);
                // System.out.println(maxHeight);
                // int numberOfTotalNodesInATree = tree.noOfNodesInATree(ans);
                // System.out.println(numberOfTotalNodesInATree);

                // int totalSum = tree.sumOfNodes(ans);
                // System.out.println(totalSum);

                // Node root = new Node(1);
                // root.left = new Node(2);
                // root.right = new Node(3);
                // root.left.left = new Node(4);
                // root.left.right = new Node(5);
                // root.right.right = new Node(6);
                // // System.out.print(ans.data);

                // Node subroot = new Node(2);
                // subroot.left = new Node(4);
                // subroot.right = new Node(5);

                // Node root = new Node(1);
                // root.left = new Node(2);
                // root.right = new Node(3);
                // root.left.left = new Node(4);
                // root.left.right = new Node(5);
                // root.right.left = new Node(6);
                // root.right.right = new Node(7);

                // // System.out.println(tree.isSubTree(root, subroot));
                // tree.topView(root);
                // System.out.println();
                // tree.kthLevel(root, 1, 3);
                // System.out.println();
                // tree.KthLevelIterative(root, 3);
                // System.out.println(tree.lca(root, 4, 5).data);

                // System.out.println(tree.minDistanceBetweenTwoNodes(root, 4, 5));
                // System.out.println(tree.KthAnccestor(root , 5 , 2));

                // System.out.println(tree.minDistanceBetweenTwoNodes(root, 4, 2));

        }
}
