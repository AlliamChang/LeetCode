public class LeetCode877 {
    public boolean stoneGame(int[] piles) {
        int[] dp = new int[piles.length];
        for (int i = 0; i < piles.length; i++) {
            dp[i] = piles[i];
        }
        for (int i = piles.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < piles.length; j++) {
                dp[j] = Math.max(piles[i] - dp[j], piles[j] - dp[j - 1]);
            }
        }
        return dp[piles.length - 1] > 0;
    }
}
