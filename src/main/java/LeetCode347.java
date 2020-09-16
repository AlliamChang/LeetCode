import java.util.*;
import java.util.stream.Collectors;

public class LeetCode347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }else {
                map.put(i, 1);
            }
        }
        PriorityQueue<int[]> topk = new PriorityQueue<>(Comparator.comparingInt(i -> i[1]));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (topk.size() == k) {
                if(topk.peek()[1] < entry.getValue()){
                    topk.poll();
                    topk.offer(new int[]{entry.getKey(), entry.getValue()});
                }
            }else {
                topk.offer(new int[]{entry.getKey(), entry.getValue()});
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = topk.poll()[0];
        }
        return res;
    }
}
