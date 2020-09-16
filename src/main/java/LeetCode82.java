public class LeetCode82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode prev = start, cur = head;
        while (cur != null && cur.next != null) {
            if(cur.val == cur.next.val){
                int val = cur.val;
                while (cur != null && cur.val == val) {
                    prev.next = cur.next;
                    cur = cur.next;
                }
            }else {
                prev = prev.next;
                cur = cur.next;
            }
        }
        return start.next;
    }
}
