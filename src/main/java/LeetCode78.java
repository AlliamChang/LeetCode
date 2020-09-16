import java.util.ArrayList;
import java.util.List;

public class LeetCode78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> cur = new ArrayList<>();
            int bitmap = i, j = 0;
            while (bitmap > 0) {
                if ((bitmap & 1) > 0) {
                    cur.add(nums[j]);
                }
                j ++;
                bitmap >>>= 1;
            }
            res.add(cur);
        }
        return res;
    }
}
