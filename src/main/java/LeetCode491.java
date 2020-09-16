import java.util.*;

public class LeetCode491 {
    public static void main(String[] args) {
        String[] s = {"1", "2", "3"};
        List<String> l = new ArrayList<>(10);
        l.add("4");
        Collections.fill(l, "a");
        System.out.println(l.get(1));
    }
}
