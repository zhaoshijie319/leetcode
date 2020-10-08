package tree;

/**
 * Given a binary tree, find the maximum path sum.
 *
 * <p>For this problem, a path is defined as any sequence of nodes from some starting node to any
 * node in the tree along the parent-child connections. The path must contain at least one node and
 * does not need to go through the root.
 *
 * <p>For example: Given the below binary tree,
 *
 * <p>1 / \ 2 3 Return 6.
 */
public class 和最大的路径 {

    private int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(-1);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(9);
        System.out.println(new 和最大的路径().maxPathSum(root));
    }

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        max = Math.max(max, root.val);
        max = Math.max(max, root.val + left);
        max = Math.max(max, root.val + right);
        max = Math.max(max, root.val + left + right);
        int leftVal = Math.max(root.val, root.val + left);
        int rightVal = Math.max(root.val, root.val + right);
        return Math.max(leftVal, rightVal);
    }
}
