public class LeetCode415 {

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1;
        int count = 0;
        while (i >= 0 && j >= 0){
            int flag = num1.charAt(i) + num2.charAt(j) - 2 * '0' + count;
            count = flag / 10;
            sb.insert(0, flag % 10);
            i --;
            j --;
        }
        while (i >= 0) {
            int flag = num1.charAt(i) + count - '0';
            count = flag / 10;
            sb.insert(0, flag % 10);
            i --;
        }
        while (j >= 0) {
            int flag = num2.charAt(j) + count - '0';
            count = flag / 10;
            sb.insert(0, flag % 10);
            j --;
        }
        if (count > 0) {
            sb.insert(0, count);
        }
        return sb.toString();
    }
}
