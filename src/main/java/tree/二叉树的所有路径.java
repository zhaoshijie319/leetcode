package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 *
 * <p>For example, given the following binary tree:
 *
 * <p>1 / \ 2 3 \ 5 All root-to-leaf paths are:
 *
 * <p>["1->2->5", "1->3"]
 */
public class 二叉树的所有路径 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        new 二叉树的所有路径().inorder(root, result, "");
        return result;
    }

    private void inorder(TreeNode node, List<String> list, String path) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                list.add(path + node.val);
            } else {
                inorder(node.left, list, path + node.val + "->");
                inorder(node.right, list, path + node.val + "->");
            }
        }
    }
}
