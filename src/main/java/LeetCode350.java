import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0) return new int[0];
        return nums1.length > nums2.length? inter(nums2, nums1):inter(nums1, nums2);
    }

    private int[] inter(int[] from, int[] to) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int i : from) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            }else{
                map.put(i, map.get(i) + 1);
            }
        }
        for (int i : to) {
            if (map.containsKey(i) && map.get(i) > 0) {
                map.put(i, map.get(i) - 1);
                res.add(i);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
