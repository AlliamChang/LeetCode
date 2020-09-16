public class LeetCode696 {
    public int countBinarySubstrings(String s) {
        int res = 0, last = 0, i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            int count = 0;
            while (i < s.length() && s.charAt(i) == c) {
                count ++;
                i ++;
            }
            res += Math.min(last, count);
            last = count;
        }
        return res;
    }
}
