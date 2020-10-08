package tree;

public class 二叉树的下一个节点 {

    static class TreeLinkNode {

        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode parent = null; // 指向父结点的指针

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode getNext(TreeLinkNode pNode) {
        if (pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while (node.left != null)
                node = node.left;
            return node;
        } else {
            while (pNode.parent != null) {
                TreeLinkNode parent = pNode.parent;
                if (parent.left == pNode)
                    return parent;
                pNode = pNode.parent;
            }
        }
        return null;
    }
}
