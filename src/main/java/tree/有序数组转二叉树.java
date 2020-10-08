package tree;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class 有序数组转二叉树 {
    public static void main(String[] args) throws Exception {
        int[] A = {1, 2, 3, 4, 5, 6};
        new 有序数组转二叉树().sortedArrayToBST(A);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;

        TreeNode root = new 有序数组转二叉树().sortedArrayToBST(nums, 0, nums.length - 1);
        preorder(root);
        return root;
    }
    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, left, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, right);
        return node;
    }

    private void preorder(TreeNode node) {
        if (node != null) {
            preorder(node.left);
            System.out.println(node.val);
            preorder(node.right);
        }
    }
}
