import java.util.HashSet;
import java.util.Set;

public class Shopee_3 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(new Shopee_3().calEncodeNumber(4));
        System.out.println(System.currentTimeMillis() - start);
    }

    /**
     * calculate correct encode number
     *
     * @param length int整型 encode string length
     * @return int整型
     */
    public int calEncodeNumber(int length) {
        if (length <= 2) return length;
        Set<Integer> set = new HashSet<>();
        int res = 2;
        for (int i = 3; i <= length; i++) {
            int now = res;
            for (int j = 2; j < i; j++) {
                if (i % j != 0) {
                    now = (now + 1) % 1000000369;
                    set.add(i * j);
                }
            }
            res = now;
            if (!set.contains(i)) {
                res = (res + 1) % 1000000369;
            }
        }
        return res;
    }
}
