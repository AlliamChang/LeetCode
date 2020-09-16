import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class Test {

    public void preorderTraversal(TreeNode head) {
        if(head == null) return;
        System.out.println(head.val);
        preorderTraversal(head.left);
        preorderTraversal(head.right);
    }
}
