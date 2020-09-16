public class LeetCode130 {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'}
        };
        new LeetCode130().solve(board);
    }

    public void solve(char[][] board) {
        if (board.length == 0) return;
        int b = board.length - 1, r = board[0].length - 1;
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                set(board, i, 0);
            }
            if (board[i][r] == 'O') {
                set(board, i, r);
            }
        }
        for (int j = 0; j < board[0].length; j++) {
            if (board[0][j] == 'O') {
                set(board, 0, j);
            }
            if (board[b][j] == 'O') {
                set(board, b, j);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void set(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        if (board[i][j] == 'O') {
            board[i][j] = 'A';
            set(board, i - 1, j);
            set(board, i + 1, j);
            set(board, i, j - 1);
            set(board, i, j + 1);
        }
    }
}
