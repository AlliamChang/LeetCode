public class LeetCode34 {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return null;
        int[] res = searchRange(nums, target, 0, nums.length);
        return nums[res[0]] == target ? res : new int[]{-1, -1};
    }

    private int[] searchRange(int[] nums, int target, int start, int end) {
        if(end - start == 1) return new int[]{start, start};
        int mid = (end + start) / 2;
        int[] ll = searchRange(nums, target, start, mid);
        int[] rr = searchRange(nums, target, mid, end);
        int left = ll[0], right = rr[1];

        if (nums[left] != target && nums[rr[0]] == target) {
            left = rr[0];
        }
        if (nums[right] != target && nums[ll[1]] == target) {
            right = ll[1];
        }
        return new int[]{left, right};
    }
}
