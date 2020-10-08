package tree;
/**
 * 题目:
 * 输入一个二叉树的根节点,求该树的深度.
 */
public class 二叉树的深度 {

    static int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);

        return leftDepth > rightDepth ? (leftDepth + 1) : (rightDepth + 1);
    }

}
