import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, LNode> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0), to = ticket.get(1);
            LNode f, t;
            if (!map.containsKey(to)) {
                t = new LNode(to);
                map.put(to, t);
            }else {
                t = map.get(to);
            }
            if (!map.containsKey(from)) {
                f = new LNode(from);
                map.put(from, f);
            }else {
                f = map.get(from);
            }
            if (f.next == null || to.compareTo(f.next.val) < 0) {
                f.next = t;
            }
        }
        LNode head = map.get("JFK");
        List<String> res = new ArrayList<>();
        while (head != null) {
            res.add(head.val);
            head = head.next;
        }
        return res;
    }
}

class LNode{
    String val;
    LNode next;

    public LNode(String val) {
        this.val = val;
    }
}
