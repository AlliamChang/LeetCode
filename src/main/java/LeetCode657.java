import java.util.HashMap;
import java.util.Map;

public class LeetCode657 {
    Map<Character, Integer[]> map = new HashMap<>();
    {
        map.put('R', new Integer[]{1, 0});
        map.put('L', new Integer[]{-1, 0});
        map.put('U', new Integer[]{0, -1});
        map.put('D', new Integer[]{0, 1});
    }
    public boolean judgeCircle(String moves) {
        Integer[] res = judge(moves, 0, moves.length() - 1);
        return res[0] == 0 && res[1] == 0;
    }

    public Integer[] judge(String moves, int left, int right) {
        if(left >= right) return map.get(moves.charAt(left));
        int mid = (left + right) / 2;
        Integer[] l = judge(moves, left, mid);
        Integer[] r = judge(moves, mid + 1, right);
        return new Integer[]{l[0] + r[0], l[1] + r[1]};
    }
}
