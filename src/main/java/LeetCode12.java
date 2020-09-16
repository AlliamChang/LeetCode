import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LeetCode12 {
//    I             1
//    V             5
//    X             10
//    L             50
//    C             100
//    D             500
//    M             1000

    public static void main(String[] args) {
        System.out.println(new LeetCode12().intToRoman(58));
    }

    private static TreeMap<Integer, String> MATCH = new TreeMap<Integer, String>(){{
        put(1, "I");
        put(4, "IV");
        put(5, "V");
        put(9, "IX");
        put(10, "X");
        put(40, "XL");
        put(50, "L");
        put(90, "XC");
        put(100, "C");
        put(400, "CD");
        put(500, "D");
        put(900, "CM");
        put(1000, "M");
    }};

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (Integer val : MATCH.descendingKeySet()) {
            while (num / val > 0) {
                sb.append(MATCH.get(val));
                num -= val;
            }
        }
        return sb.toString();
    }
}
