import java.util.ArrayList;
import java.util.List;

public class LeetCode17 {

    private static String[][] letters = {
            {"a", "b", "c"},
            {"d", "e", "f"},
            {"g", "h", "i"},
            {"j", "k", "l"},
            {"m", "n", "o"},
            {"p", "q", "r", "s"},
            {"t", "u", "v"},
            {"w", "x", "y", "z"}
    };

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() == 0) return res;
        combination(digits, 0, new StringBuilder(), res);
        return res;
    }

    private void combination(String digits, int i, StringBuilder now, List<String> res) {
        if(i == digits.length()) {
            res.add(now.toString());
            return;
        }
        String[] letter = letters[digits.charAt(i) - '2'];
        for (int j = 0; j < letter.length; j++) {
            now.append(letter[j]);
            combination(digits, i + 1, now, res);
            now.deleteCharAt(now.length() - 1);
        }
    }
}
