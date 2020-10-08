package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * <p>Note: You may assume that duplicates do not exist in the tree.
 */
public class 后序中序构造二叉树 {

    private Map<Integer, Integer> INDEX = new HashMap<>();
    private static int postIndex;

    public static void main(String[] args) throws Exception {
        int in[] = new int[]{1, 2};
        int post[] = new int[]{1, 2};
        TreeNode root = new 后序中序构造二叉树().buildTree(in, post);
        new 后序中序构造二叉树().preorderPrint(root);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int count = 0;
        for (int i : inorder) INDEX.put(i, count++);
        postIndex = postorder.length - 1;
        return build(0, inorder.length - 1, postorder);
    }

    private void preorderPrint(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preorderPrint(root.left);
            preorderPrint(root.right);
        }
    }

    private TreeNode build(int s, int e, int[] postorder) {
        if (postIndex >= 0 && s <= e) {
            int poi = postorder[postIndex];

            int ini = INDEX.get(poi);

            TreeNode node = new TreeNode(poi);
            postIndex--;

            if (s == e) return node; // leaf node

            node.right = build(ini + 1, e, postorder);
            node.left = build(s, ini - 1, postorder);

            return node;
        }
        return null;
    }
}
