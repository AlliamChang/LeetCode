public class LeetCode148 {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if(slow == head) return head;
        ListNode mid = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode start = new ListNode(0);
        ListNode node = start;
        while (left != null && right != null) {
            if (left.val < right.val) {
                node.next = left;
                left = left.next;
            }else {
                node.next = right;
                right = right.next;
            }
            node = node.next;
        }
        if (left != null) {
            node.next = left;
        }
        if (right != null) {
            node.next = right;
        }
        return start.next;
    }
}
