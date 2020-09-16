import java.util.ArrayList;
import java.util.List;

public class LeetCode93 {
    public static void main(String[] args) {
        new LeetCode93().restoreIpAddresses("0000");
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        restoreIp(res, s, 1, 0, "");
        return res;
    }

    public void restoreIp(List<String> res, String s, int index, int start, String ip) {
        if (index == 5) {
            if (start == s.length()) {
                res.add(ip.substring(0, ip.length() - 1));
            }
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if(start + i > s.length()) break;
            int num = Integer.parseInt(s.substring(start, start + i));
            if(num > 255) break;
            restoreIp(res, s, index + 1, start + i, ip + num + ".");
            if(num == 0) break;
        }
    }
}
