import java.util.ArrayList;
import java.util.HashMap;

public class LeetCode529 {

    public static void main(String[] args){
        char[][] board = {
                {'E', 'E'},
                {'E', 'E'}
        };
        new LeetCode529().updateBoard(board, new int[]{0, 0});
        System.out.println("finish");
    }

    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];
        if(board[x][y] == 'M'){
            board[x][y] = 'X';
        }else {
            update(board, x, y);
        }
        return board;
    }

    private void update(char[][] board, int x, int y) {
        if(board[x][y] != 'E') return;
        board[x][y] = 'B';
        int num = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (isValid(board, i, j) &&
                        board[i][j] == 'M') {
                    num ++;
                }
            }
        }
        if (num == 0) {
            for (int i = x - 1; i <= x + 1; i++) {
                for (int j = y - 1; j <= y + 1; j++) {
                    if (isValid(board, i, j) &&
                            (i != x || j != y)) {
                        update(board, i, j);
                    }
                }
            }
        }else {
            board[x][y] = (char) ('0' + num);
        }
    }

    private boolean isValid(char[][] board, int x, int y) {
        return (0 <= x && x < board.length) && (0 <= y && y < board[0].length);
    }
}
