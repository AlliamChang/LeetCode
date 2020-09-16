public class LeetCode8 {
    public int myAtoi(String str) {
        if(str.length() == 0) return 0;
        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ') {
            i ++;
        }
        if (i >= str.length()) {
            return 0;
        }else if (('0' <= str.charAt(i) && str.charAt(i) <= '9') || (str.charAt(i) == '-' || str.charAt(i) == '+')) {
        }else {
            return 0;
        }
        boolean isNegative = false;
        long num = 0;
        if(str.charAt(i) == '-'){
            isNegative = true;
            i ++;
        } else if (str.charAt(i) == '+') {
            i ++;
        }
        while (i < str.length() && ('0' <= str.charAt(i) && str.charAt(i) <= '9')) {
            num = num * 10 + str.charAt(i) - '0';
            if (isNegative && -num < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }else if(!isNegative && num > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            i ++;
        }

        return (int)(isNegative? -num:num);
    }
}
