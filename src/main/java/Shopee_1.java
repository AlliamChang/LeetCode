import java.util.Scanner;

public class Shopee_1 {

    static int i = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        build(str, sb);
        System.out.println("\"" + sb.substring(0, sb.length() - 2) + "\"");
    }

    public static void build(String str, StringBuilder sb) {
        for (; i < str.length(); i++) {
            if(str.charAt(i) == '['){
                i ++;
                build(str, sb);
            } else if (str.charAt(i) == '"') {
                i ++;
                while (str.charAt(i) != '"') {
                    sb.append(str.charAt(i));
                    i ++;
                }
                sb.append("\\n");
            }
        }
    }
}
