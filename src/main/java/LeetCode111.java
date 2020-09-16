public class LeetCode111 {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        int res = Math.min(left, right);
        if (left == 0) {
            res = right;
        } else if (right == 0) {
            res = left;
        }
        return res + 1;
    }
}
