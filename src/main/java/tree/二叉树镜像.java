package tree;
/**
 * 题目:
 * 请完成一个函数,输入一个二叉树,该函数输出他的的镜像.
 */
public class 二叉树镜像 {
    /**
     * 思路:
     * 先序遍历这棵树的每个结点,如果遍历到结点有子结点,就交换它的两个子结点,
     * 当交换完所有非叶子结点的左右结点之后,就的到了树的镜像.
     */

    private static void mirrorRecursively(TreeNode head) {
        if (head == null) {
            return;
        }
        if (head.left == null && head.right == null) {
            return;
        }

        TreeNode temp = head.left;
        head.left = head.right;
        head.right = temp;

        if (head.left != null) {
            mirrorRecursively(head.left);
        }

        if (head.right != null) {
            mirrorRecursively(head.right);
        }
    }
}
