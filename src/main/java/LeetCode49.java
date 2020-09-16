import java.util.*;

public class LeetCode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] cs = strs[i].toCharArray();
            Arrays.sort(cs);
            String same = new String(cs);
            if (!map.containsKey(same)) {
                map.put(same, new ArrayList<>());
            }
            map.get(same).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}
