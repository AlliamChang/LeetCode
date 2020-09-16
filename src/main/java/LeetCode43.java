
import java.util.ArrayList;
import java.util.List;

public class LeetCode43 {
    public static void main(String[] args) {
        System.out.println(new LeetCode43().multiply("999", "11"));
    }

    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        return num1.length() < num2.length()? multi(num1, num2):multi(num2, num1);
    }

    private String multi(String from, String to) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for (int i = from.length()- 1; i >= 0; i--) {
            int x = from.charAt(i) - '0';
            if(x == 0) {
                if (to.length() - i - 1 >= res.size()) {
                    res.add(0);
                }
                continue;
            }
            for (int j = to.length() - 1; j >= 0; j--) {
                int y = to.charAt(j) - '0';
                int a = (x * y) % 10;
                int b = (x * y) / 10;
                int k = from.length() - i - 1 + to.length() - j - 1;
                do {
                    if (k >= res.size()) {
                        res.add(a);
                    } else {
                        int tmp = res.get(k);
                        b += (tmp + a) / 10;
                        res.set(k, (tmp + a) % 10);
                    }
                    k++;
                    a = b;
                    b = 0;
                } while (a > 0);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = res.size() - 1; i >= 0; i--) {
            sb.append(res.get(i));
        }
        return sb.toString();
    }

}
