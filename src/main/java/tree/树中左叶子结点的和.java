package tree;

/**
 * Find the sum of all left leaves in a given binary tree.
 *
 * <p>Example:
 *
 * <p>3 / \ 9 20 / \ 15 7
 *
 * <p>There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
public class 树中左叶子结点的和 {
    public static void main(String[] args) throws Exception {
    }

    public int sumOfLeftLeaves(TreeNode root) {
        return inorder(root, false);
    }

    private int inorder(TreeNode node, boolean isLeft) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                if (isLeft) {
                    return node.val;
                } else return 0;
            }
            return inorder(node.left, true) + inorder(node.right, false);
        }
        return 0;
    }
}
