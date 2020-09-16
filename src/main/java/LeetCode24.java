public class LeetCode24 {

    public ListNode swapPairs(ListNode head) {
        ListNode start = new ListNode(0);
        start.next = head;

        ListNode prev = start;
        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;

            prev.next = second;
            first.next = second.next;
            second.next = first;

            head = first.next;
            prev = first;
        }

        return start.next;
    }
}
