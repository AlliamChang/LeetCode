import java.util.Arrays;
import java.util.Map;

public class LeetCode16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int x = i + 1, y = nums.length - 1;
            while (x < y) {
                int sum = nums[i] + nums[x] + nums[y];
                int tmp = sum - target;
                if (Math.abs(tmp) < Math.abs(diff)) {
                    diff = tmp;
                }
                if (sum < target) {
                    x ++;
                } else if (sum > target) {
                    y --;
                }else{
                    i = nums.length;
                    break;
                }
            }
        }
        return target + diff;
    }
}
