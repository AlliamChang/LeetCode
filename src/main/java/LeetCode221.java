public class LeetCode221 {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'},
        };
        new LeetCode221().maximalSquare(matrix);
    }
    public int maximalSquare(char[][] matrix) {
        int maxLen = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 || j == 0) {
                    maxLen = Math.max(maxLen, matrix[i][j] - '0');
                }else if(matrix[i][j] > '0') {
                    matrix[i][j] = (char)(Math.min(Math.min(matrix[i - 1][j - 1], matrix[i - 1][j]), matrix[i][j - 1]) + 1);
                    maxLen = Math.max(matrix[i][j] - '0', maxLen);
                }
            }
        }
        return maxLen * maxLen;
    }
}
