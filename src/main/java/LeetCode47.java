import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        do {
            List<Integer> one = new ArrayList<>();
            for (int i : nums) {
                one.add(i);
            }
            res.add(one);
        } while (nextPermutation(nums));
        return res;
    }

    private boolean nextPermutation(int[] nums) {
        int prev = nums.length - 2;
        while (prev >= 0 && nums[prev] >= nums[prev + 1]) {
            prev--;
        }
        if (prev >= 0) {
            int target = nums.length - 1;
            while (nums[prev] >= nums[target]) {
                target --;
            }
            swap(nums, prev, target);
            reverse(nums, prev + 1);
        } else {
            return false;
        }
        return true;
    }

    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
