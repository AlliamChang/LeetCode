import java.util.ArrayList;
import java.util.List;

public class LeetCode39 {
    public static void main(String[] args) {
        new LeetCode39().combinationSum(new int[]{2, 3, 7}, 7);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>[] dp = new ArrayList[target + 1];
        dp[0] = new ArrayList(){{
            add(new ArrayList<>());
        }};
        for (int i = 0; i < candidates.length; i++) {
            int cand = candidates[i];
            for (int j = cand; j <= target; j++) {
                if(dp[j] == null) dp[j] = new ArrayList<>();
                List<List<Integer>> last = dp[j - cand];
                if (last == null) continue;
                for (List<Integer> list : last) {
                    List<Integer> one = new ArrayList<>(list);
                    one.add(cand);
                    dp[j].add(one);
                }
            }
        }
        return dp[target] == null? new ArrayList<>():dp[target];
    }
}
