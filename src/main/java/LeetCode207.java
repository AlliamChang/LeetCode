import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            edges.get(prerequisites[i][1]).add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]] ++;
        }

        int res = 0;
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.addLast(i);
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.pollFirst();
            res ++;
            for (Integer i : edges.get(now)) {
                inDegree[i] --;
                if (inDegree[i] == 0) {
                    queue.addLast(i);
                }
            }
        }

        return res == numCourses;
    }
}
