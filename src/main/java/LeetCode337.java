public class LeetCode337 {
    public int rob(TreeNode root) {
        int[] res = dps(root);
        return Math.max(res[0], res[1]);
    }

    public int[] dps(TreeNode node) {
        if (node == null) return new int[]{0, 0};
        int[] l = dps(node.left);
        int[] r = dps(node.right);
        int select = l[0] + node.val + r[0];
        int unselect = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return new int[]{unselect, select};
    }
}
