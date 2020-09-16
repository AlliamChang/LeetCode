public class LinkSort {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n5;
        n5.next = n2;
        n2.next = n4;
        n4.next = n3;

        ListNode n = new LinkSort().sort(n1);
        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }
    }

    public ListNode sort(ListNode start) {
        if (start == null || start.next == null) return start;

        ListNode slow = start, fast = start;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;
        slow.next = null;
        ListNode l1 = sort(start);
        ListNode l2 = sort(fast);

        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode start = new ListNode(0);
        ListNode now = start;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                now.next = l1;
                l1 = l1.next;
            } else {
                now.next = l2;
                l2 = l2.next;
            }
            now = now.next;
        }
        if (l1 != null) {
            now.next = l1;
        }
        if (l2 != null) {
            now.next = l2;
        }
        return start.next;
    }
}
