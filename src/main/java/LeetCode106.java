public class LeetCode106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, postorder, 0, postorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode build(int[] inOrder, int[] postOrder, int pLeft, int pRight, int iLeft, int iRight) {
        if(iLeft > iRight) return null;
        int nodeVal = postOrder[pRight];
        int i = iLeft;
        while (i <= iRight) {
            if (inOrder[i] == nodeVal) {
                break;
            }
            i ++;
        }
        int leftLen = i - iLeft;
        int rightLen = iRight - i;
        TreeNode node = new TreeNode(nodeVal);
        node.left = build(inOrder, postOrder, pLeft, pLeft + leftLen - 1, iLeft, i - 1);
        node.right = build(inOrder, postOrder, pRight - rightLen, pRight - 1, i + 1, iRight);
        return node;
    }
}
