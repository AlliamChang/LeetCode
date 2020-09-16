import java.util.ArrayList;
import java.util.List;

public class LeetCode77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        combine(res, n, k, 1, new ArrayList<>());
        return res;
    }

    private void combine(List<List<Integer>> res, int n, int k, int i, List<Integer> now) {
        if (k == 0) {
            res.add(new ArrayList<>(now));
        }else {
            for (int j = i; j <= n; j++) {
                now.add(j);
                combine(res, n, k - 1, j + 1, now);
                now.remove(now.size() - 1);
            }
        }
    }
}
