import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class ForOffer20 {
    enum State {
        START,
        SYMBOL_BEFORE_E,
        NUMBER_BEFORE_POINT,
        POINT_WITHOUT_NUM,
        POINT,
        NUMBER_AFTER_POINT,
        E,
        SYMBOL_AFTER_E,
        NUMBER_AFTER_E,
        FINISH,
    }

    enum CharType {
        UNKNOWN,
        SYMBOL,
        NUMBER,
        E,
        POINT,
        FINISH,
    }

    private CharType toCharType(char c) {
        if (c == '+' || c == '-') {
            return CharType.SYMBOL;
        } else if (c == 'e' || c == 'E') {
            return CharType.E;
        } else if (c == '.') {
            return CharType.POINT;
        } else if ('0' <= c && c <= '9') {
            return CharType.NUMBER;
        } else if (c == ' ') {
            return CharType.FINISH;
        } else {
            return CharType.UNKNOWN;
        }
    }

    public boolean isNumber(String s) {
        Map<State, Map<CharType, State>> transfer = new HashMap<>();
        transfer.put(State.START, new HashMap<CharType, State>() {{
            put(CharType.POINT, State.POINT_WITHOUT_NUM);
            put(CharType.NUMBER, State.NUMBER_BEFORE_POINT);
            put(CharType.SYMBOL, State.SYMBOL_BEFORE_E);
        }});
        transfer.put(State.SYMBOL_BEFORE_E, new HashMap<CharType, State>() {{
            put(CharType.NUMBER, State.NUMBER_BEFORE_POINT);
            put(CharType.POINT, State.POINT_WITHOUT_NUM);
        }});
        transfer.put(State.NUMBER_BEFORE_POINT, new HashMap<CharType, State>() {{
            put(CharType.NUMBER, State.NUMBER_BEFORE_POINT);
            put(CharType.POINT, State.POINT);
            put(CharType.E, State.E);
            put(CharType.FINISH, State.FINISH);
        }});
        transfer.put(State.POINT, new HashMap<CharType, State>() {{
            put(CharType.NUMBER, State.NUMBER_AFTER_POINT);
            put(CharType.E, State.E);
            put(CharType.FINISH, State.FINISH);
        }});
        transfer.put(State.NUMBER_AFTER_POINT, new HashMap<CharType, State>() {{
            put(CharType.NUMBER, State.NUMBER_AFTER_POINT);
            put(CharType.E, State.E);
            put(CharType.FINISH, State.FINISH);
        }});
        transfer.put(State.POINT_WITHOUT_NUM, new HashMap<CharType, State>() {{
            put(CharType.NUMBER, State.NUMBER_AFTER_POINT);
        }});
        transfer.put(State.E, new HashMap<CharType, State>() {{
            put(CharType.NUMBER, State.NUMBER_AFTER_E);
            put(CharType.SYMBOL, State.SYMBOL_AFTER_E);
        }});
        transfer.put(State.SYMBOL_AFTER_E, new HashMap<CharType, State>() {{
            put(CharType.NUMBER, State.NUMBER_AFTER_E);
        }});
        transfer.put(State.NUMBER_AFTER_E, new HashMap<CharType, State>() {{
            put(CharType.NUMBER, State.NUMBER_AFTER_E);
            put(CharType.FINISH, State.FINISH);
        }});
        transfer.put(State.FINISH, new HashMap<>());

        State now = State.START;
        s = s.trim() + " ";
        for (int i = 0; i < s.length(); i++) {
            CharType type = toCharType(s.charAt(i));
            now = transfer.get(now).get(type);
            if (now == null) {
                break;
            }
        }
        return now == State.FINISH;
    }
}
