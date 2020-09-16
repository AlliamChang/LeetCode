import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode40 {

    public static void main(String[] args) {
        new LeetCode40().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        combination(res, candidates, target, 0, new ArrayList<>());
        return res;
    }

    private void combination(List<List<Integer>> res, int[] candidates, int rest, int i, List<Integer> now) {
        if(rest == 0){
            res.add(new ArrayList<>(now));
            return;
        }
        if(i >= candidates.length) return;
        List<Integer> next = new ArrayList<>(now);
        for (int j = i; j < candidates.length; j++) {
            if(j > i && candidates[j] == candidates[j - 1]){
                continue;
            }
            if(candidates[j] > rest) break;
            next.add(candidates[j]);
            combination(res, candidates, rest - candidates[j], j + 1, next);
            next.remove(next.size() - 1);
        }
    }
}
