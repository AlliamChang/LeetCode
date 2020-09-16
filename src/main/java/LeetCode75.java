public class LeetCode75 {

    public void sortColors(int[] nums) {
        int p0 = 0, p2 = nums.length - 1;
        int curr = 0;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                swap(nums, curr, p0);
                p0++;
                curr++;
            } else if (nums[curr] == 2) {
                swap(nums, curr, p2);
                p2--;
            } else {
                curr++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
