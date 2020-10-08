package tree;

/**
 * Convert a BST to a sorted circular doubly-linked list in-place. Think of the left and right
 * pointers as synonymous to the previous and next pointers in a doubly-linked list.
 *
 * <p>Solution: Do a preorder traversal, keep track of previous node at every step and construct the
 * dd-linked list in-place.
 */
public class 平衡二叉树转双链表 {

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public static void main(String[] args) throws Exception {
        Node root = new Node(4, new Node(2, null, null), new Node(5, null, null));
        Node result = new 平衡二叉树转双链表().treeToDoublyList(root);
        // print result
    }

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        Node head = new Node();
        Node last = preorder(root, head);
        last.right = head.right;
        head.right.left = last;
        return head.right;
    }

    Node preorder(Node node, Node prev) {
        if (node == null) return prev;
        else {
            Node left = preorder(node.left, prev);
            left.right = node;
            node.left = left;
            return preorder(node.right, node);
        }
    }

    private TreeNode pre = null;
    private TreeNode head = null;

    public TreeNode Convert(TreeNode root) {
        inOrder(root);
        return head;
    }

    private void inOrder(TreeNode node) {
        if (node == null)
            return;
        inOrder(node.left);
        node.left = pre;
        if (pre != null)
            pre.right = node;
        pre = node;
        if (head == null)
            head = node;
        inOrder(node.right);
    }
}
