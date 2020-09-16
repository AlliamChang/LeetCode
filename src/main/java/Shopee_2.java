import java.util.Stack;

public class Shopee_2 {

    public static void main(String[] args) {
        System.out.println(new Shopee_2().checkValidString("*)*("));
    }
    /**
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean checkValidString(String s) {
        // write code here

        return check(s.toCharArray(), 0, new Stack<>());
    }

    private boolean check(char[] s, int i, Stack<Character> stack) {
        if (i == s.length) return stack.isEmpty();
        char c = s[i];
        boolean valid = true;
        if (c == '(') {
            stack.push(c);
            valid = check(s, i + 1, stack);
            stack.pop();
        } else if (c == ')') {
            if (stack.isEmpty()) {
                valid = false;
            } else {
                stack.pop();
                valid = check(s, i + 1, stack);
                stack.push('(');
            }
        } else {
            valid = check(s, i + 1, stack);
            if(!valid){
                s[i] = ')';
                valid = check(s, i, stack);
            }
            if(!valid){
                s[i] = '(';
                valid = check(s, i, stack);
            }
        }
        return valid;
    }
}
