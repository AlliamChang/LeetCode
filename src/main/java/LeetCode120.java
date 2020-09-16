import java.util.List;

public class LeetCode120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 0) return 0;
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> last = triangle.get(i - 1);
            List<Integer> col = triangle.get(i);
            for (int j = 0; j < col.size(); j++) {
                if(j - 1 < 0) col.set(j, col.get(j) + last.get(j));
                else if(j >= last.size()) col.set(j, col.get(j) + last.get(j - 1));
                else col.set(j, Math.min(col.get(j) + last.get(j), col.get(j) + last.get(j - 1)));
            }
        }
        int min = triangle.get(triangle.size() - 1).get(0);
        for (Integer i : triangle.get(triangle.size() - 1)) {
            min = Math.min(min, i);
        }
        return min;
    }
}
