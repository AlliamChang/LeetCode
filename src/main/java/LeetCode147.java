public class LeetCode147 {
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return null;
        ListNode sorted = new ListNode(0);
        ListNode node = head;
        while (node != null) {
            ListNode now = sorted;
            while (now.next != null && now.next.val < node.val) {
                now = now.next;
            }
            ListNode next = now.next;
            ListNode tmp = node.next;
            now.next = node;
            node.next = next;
            node = tmp;
        }

        return sorted.next;
    }
}
