package tree;

/**
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 *
 * <p>Note: If the given node has no in-order successor in the tree, return null.
 *
 * <p>Solution: The below solution works with worst case time complexity of O(h) where h is the
 * height of the tree. If the current node is <= target_node, recursively iterate the right of the
 * current node. else if the current node is > target_node then mark the current node as the
 * successor and recursively iterate the left of the current node.
 */
public class 中序遍历的下一个节点 {
    public static void main(String[] args) throws Exception {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(6);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(13);
        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(14);
        root.right.right = new TreeNode(17);
        TreeNode ans = new 中序遍历的下一个节点().inorderSuccessor(root, root.right.left.right);
        if (ans != null) System.out.println(ans.val);
        else System.out.println(ans);
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return inOrder(root, p, null);
    }

    private TreeNode inOrder(TreeNode curr, TreeNode target, TreeNode successor) {
        if (curr == null) return successor;
        if (curr.val <= target.val) return inOrder(curr.right, target, successor);
        return inOrder(curr.left, target, curr); // make the current node as successor
    }
}
