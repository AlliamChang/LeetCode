import java.util.LinkedList;
import java.util.Queue;

public class LeetCode114 {
    public void flatten(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        preOrder(root, queue);
        TreeNode node = queue.poll();
        while (!queue.isEmpty()) {
            node.left = null;
            node.right = queue.poll();
            node = node.right;
        }
    }

    private void preOrder(TreeNode root, Queue<TreeNode> queue) {
        if(root == null) return;
        queue.offer(root);
        preOrder(root.left, queue);
        preOrder(root.right, queue);
    }
}
