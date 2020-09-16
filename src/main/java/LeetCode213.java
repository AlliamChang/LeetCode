public class LeetCode213 {

    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }

    public int rob(int[] nums, int start, int end) {
        if(start >= end) return 0;
        int[] dp = new int[end - start + 1];
        dp[1] = nums[start];
        for (int i = 1; i < end - start; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i + start]);
        }
        return dp[end - start];
    }
}
