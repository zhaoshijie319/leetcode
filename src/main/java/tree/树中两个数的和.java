package tree;

import java.util.HashSet;

/**
 * Given a Binary Search Tree and a target number, return true if there exist two elements
 * in the BST such that their sum is equal to the given target.
 *
 * <p>Example 1: Input: 5 / \ 3 6 / \ \ 2 4 7
 *
 * <p>Target = 9
 *
 * <p>Output: True Example 2: Input: 5 / \ 3 6 / \ \ 2 4 7
 *
 * <p>Target = 28
 *
 * <p>Output: False
 */
public class 树中两个数的和 {
    public boolean findTarget(TreeNode root, int k) {
        return inorder(root, new HashSet<>(), k);
    }

    private boolean inorder(TreeNode node, HashSet<Integer> set, int k) {
        if (node != null) {
            int req = k - (node.val);
            if (set.contains(req)) {
                return true;
            }
            set.add(node.val);
            if (inorder(node.left, set, k)) {
                return true;
            } else {
                if (inorder(node.right, set, k)) {
                    return true;
                }
            }
        }
        return false;
    }
}
