import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;

public class LeetCode79 {
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        new LeetCode79().exist(board, "ABCCED");
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    boolean exist = exist(board, word, 0, i, j);
                    if (exist) return true;
                }
            }
        }

        return false;
    }

    private boolean exist(char[][] board, String word, int i, int j, int k) {
        if (i == word.length()) return true;
        if (!(0 <= j && j < board.length && 0 <= k && k < board[0].length)) return false;
        if (board[j][k] == word.charAt(i)) {
            board[j][k] = '\0';
            boolean res = exist(board, word, i + 1, j - 1, k)
                    || exist(board, word, i + 1, j + 1, k)
                    || exist(board, word, i + 1, j, k - 1)
                    || exist(board, word, i + 1, j, k + 1);
            board[j][k] = word.charAt(i);
            return res;
        } else {
            return false;
        }
    }
}
