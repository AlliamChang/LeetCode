import java.util.ArrayList;
import java.util.List;

public class LeetCode216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        combine(res, k, n, 9, new ArrayList<>());
        return res;
    }

    private void combine(List<List<Integer>> res, int k, int rest, int start, List<Integer> cur) {
        if(k == 0){
            if(rest == 0) res.add(new ArrayList<>(cur));
            return;
        }
        int nums = Math.min(rest, start);
        for (int i = nums; i > 0; i--) {
            cur.add(i);
            combine(res, k - 1, rest - i, i - 1, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
