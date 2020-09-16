
import java.util.*;

public class LeetCode51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] queen = new int[n];
        Set<Integer> col = new HashSet<>();
        Set<Integer> diagonal1 = new HashSet<>();
        Set<Integer> diagonal2 = new HashSet<>();
        backtrace(0, queen, col, diagonal1, diagonal2, res);
        return res;
    }

    private void backtrace(int i, int[] queen, Set<Integer> col, Set<Integer> diagonal1, Set<Integer> diagonal2, List<List<String>> res) {
        if (i == queen.length) {
            generate(queen, res);
        } else {
            for (int j = 0; j < queen.length; j++) {
                if (col.contains(j)) {
                    continue;
                } else if (diagonal1.contains(j - i)) {
                    continue;
                } else if (diagonal2.contains(j + i)) {
                    continue;
                }else {
                    col.add(j);
                    diagonal1.add(j - i);
                    diagonal2.add(j + i);
                    queen[i] = j;
                    backtrace(i + 1, queen, col, diagonal1, diagonal2, res);
                    col.remove(j);
                    diagonal1.remove(j - i);
                    diagonal2.remove(j + i);
                    queen[i] = -1;
                }
            }
        }
    }

    private void generate(int[] queen, List<List<String>> res) {
        char[] fills = new char[queen.length];
        Arrays.fill(fills, '.');
        List<String> one = new ArrayList<>();
        for (int i : queen) {
            fills[i] = 'Q';
            one.add(new String(fills));
            fills[i] = '.';
        }
        res.add(one);
    }
}
