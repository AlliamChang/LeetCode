import java.util.HashMap;
import java.util.Map;

public class LeetCode138 {
    private Map<RandomNode, RandomNode> map = new HashMap<>();

    public RandomNode copyRandomList(RandomNode head) {
        if(head == null) return null;
        RandomNode new_;
        if (map.containsKey(head)) {
            new_ = map.get(head);
        } else {
            new_ = new RandomNode(head.val);
            map.put(head, new_);
        }
        new_.next = copyRandomList(head.next);
        new_.random = map.get(head.random);
        return new_;
    }
}
