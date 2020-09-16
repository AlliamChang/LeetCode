import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class LeetCode841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> searched = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while (!stack.isEmpty()) {
            int now = stack.pop();
            searched.add(now);
            List<Integer> next = rooms.get(now);
            for (Integer i : next) {
                if (!searched.contains(i)) {
                    stack.push(i);
                }
            }
        }
        return rooms.size() == searched.size();
    }

}
