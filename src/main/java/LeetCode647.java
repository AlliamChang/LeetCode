public class LeetCode647 {
    public int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length() * 2 - 1; i++) {
            int l = i / 2, r = i / 2 + i % 2;
            while (l >= 0 && r < s.length()) {
                if (s.charAt(l) == s.charAt(r)) {
                    res ++;
                    l --;
                    r ++;
                }else {
                    break;
                }
            }
        }
        return res;
    }
}
