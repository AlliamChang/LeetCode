import java.util.Stack;

public class LeetCode20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        boolean valid = true;
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            }else if(stack.isEmpty()){
                valid = false;
                break;
            }else {
                char top = stack.pop();
                if ((c == '}' && top != '{') || (c == ')' && top != '(') || (c == ']' && top != '[')) {
                    valid = false;
                    break;
                }
            }
        }
        return stack.isEmpty() && valid;
    }
}
