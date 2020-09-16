public class ForOffer25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
