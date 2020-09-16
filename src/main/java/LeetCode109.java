public class LeetCode109 {
    public static void main(String[] args) {
        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(4);
        n4.next = n5;
        ListNode n3 = new ListNode(3);
        n3.next = n4;
        ListNode n2 = new ListNode(2);
        n2.next = n3;
        ListNode n1 = new ListNode(1);
        n1.next = n2;

        new LeetCode109().sortedListToBST(n1);
    }

    public TreeNode sortedListToBST(ListNode head) {
        return sortedListToBST(head, null);
    }

    private TreeNode sortedListToBST(ListNode head, ListNode last) {
        if (head == last) return null;
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode fast = start, slow = start;
        while (fast != last) {
            slow = slow.next;
            fast = fast.next;
            if (fast != last) fast = fast.next;
        }
        TreeNode tHead = new TreeNode(slow.val);
        tHead.left = sortedListToBST(head, slow);
        tHead.right = sortedListToBST(slow.next, last);
        return tHead;
    }
}
