public class LeetCode36 {
    public boolean isValidSudoku(char[][] board) {
        int[] col = new int[9];
        int[] row = new int[9];
        int[] group = new int[9];
        boolean res = true;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j] - '0';
                if ((col[i] & (1 << num)) > 0) {
                    res = false;
                    break;
                } else {
                    col[i] |= 1 << num;
                }
                if ((row[j] & (1 << num)) > 0) {
                    res = false;
                    break;
                } else {
                    row[j] |= 1 << num;
                }
                if ((group[i / 3 * 3 + j / 3] & (1 << num)) > 0) {
                    res = false;
                    break;
                } else {
                    group[i / 3 * 3 + j / 3] |= 1 << num;
                }
            }
            if (!res) {
                break;
            }
        }
        return res;
    }
}
