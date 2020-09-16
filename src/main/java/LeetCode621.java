import java.util.*;

public class LeetCode621 {
    public int leastInterval(char[] tasks, int n) {
        int[] taskMap = new int[26];
        for (char c : tasks) {
            taskMap[c - 'A'] ++;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(26, Collections.reverseOrder());
        for (int i : taskMap) {
            if(i > 0) queue.add(i);
        }
        int res = 0;
        while (!queue.isEmpty()) {
            List<Integer> coolDown = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                if (coolDown.isEmpty() && queue.isEmpty()) {
                    break;
                }
                if(!queue.isEmpty()) {
                    if (queue.peek() > 1) {
                        coolDown.add(queue.poll() - 1);
                    }else {
                        queue.poll();
                    }
                }
                res ++;
            }
            coolDown.forEach(queue::offer);
        }
        return res;
    }
}
