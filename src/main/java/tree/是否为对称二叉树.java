package tree;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * <p>For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 * <p>1 / \ 2 2 / \ / \ 3 4 4 3
 *
 * <p>But the following [1,2,2,null,3,null,3] is not: 1 / \ 2 2 \ \ 3 3
 */
public class 是否为对称二叉树 {
    public static void main(String[] args) throws Exception {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(4);
        node.right = new TreeNode(5);
        System.out.println(new 是否为对称二叉树().isSymmetric(node));
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        else if (left == null || right == null) return false;
        return dfs(left.left, right.right) && left.val == right.val && dfs(left.right, right.left);
    }
}
