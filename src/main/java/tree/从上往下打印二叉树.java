package tree;

import java.util.LinkedList;

/**
 * 题目:
 * <p>
 * 从上往下打印二叉树的每个结点,同一层的结点按照从左到右的顺序打印.
 * <p>
 * 8
 * |  \
 * 6  10
 * | \  | \
 * 5  7  9 11
 */
public class 从上往下打印二叉树 {
    /**
     * 思路:
     * 每一次打印一个结点的时候,如果该结点有子结点,则把该结点的子节点放到一个队列的末尾.
     * 接下再来到队列的头部取出最早进入队列的结点,重复前面的打印操作,直至队列中所有的结点都被打印出来为止.
     */

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);

        TreeNode _6 = new TreeNode(6);
        TreeNode _10 = new TreeNode(10);
        root.left = _6;
        root.right = _10;

        TreeNode _5 = new TreeNode(5);
        TreeNode _7 = new TreeNode(7);
        _6.left = _5;
        _6.right = _7;

        TreeNode _9 = new TreeNode(9);
        TreeNode _11 = new TreeNode(11);
        _10.left = _9;
        _10.right = _11;

        print(root);

        printNodeByLevel(root);
    }

    static void print(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size = queue.size();
        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();

            System.out.printf(node.val + " ");

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            size--;
            if (size == 0) {
                System.out.println();
                size = queue.size();
            }
        }
    }

    private static int printNodeAtLevel(TreeNode node, int level) {
        if (node == null || level < 0) {
            return 0;
        }
        if (level == 0) {
            System.out.printf(node.val + " ");
            return 1;
        }

        return printNodeAtLevel(node.left, level - 1) + printNodeAtLevel(node.right, level - 1);
    }

    private static void printNodeByLevel(TreeNode node) {
        if (node == null) {
            return;
        }

        for (int level = 0; ; level++) {
            if (printNodeAtLevel(node, level) == 0) {
                break;
            }
            System.out.println();
        }
    }
}
