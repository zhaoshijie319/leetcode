package tree;

/**
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the
 * original BST is changed to the original key plus sum of all keys greater than the original key in BST.
 *
 * <p>Example:
 *
 * <p>Input: The root of a Binary Search Tree like this: 5 / \ 2 13
 *
 * <p>Output: The root of a Greater Tree like this: 18 / \ 20 13
 */
public class 累加构建平衡数 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.right = new TreeNode(13);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(3);
        TreeNode result = new 累加构建平衡数().convertBST(node);
        System.out.println(result.val);
    }

    public TreeNode convertBST(TreeNode root) {
        postOrder(root, 0);
        return root;
    }

    private int postOrder(TreeNode node, int value) {
        if (node == null) return value;
        int right = postOrder(node.right, value);
        node.val = node.val + right;
        return postOrder(node.left, node.val);
    }
}
