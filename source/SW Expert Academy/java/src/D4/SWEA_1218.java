package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.Stack;

public class SWEA_1218 {
    static int n;
    static String str;
    static Stack<Character> stack;

    public static void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {
            n = Integer.parseInt(br.readLine());
            str = br.readLine();
            stack = new Stack<>();
            System.out.println("#" + t + " " + check_stack());
        }
    }

    private static int check_stack() {
        char c;
        for (int i = 0; i < n; i++) {
            c = str.charAt(i);
            switch (c) {
                case ']':
                    if (stack.pop() != '[')
                        return 0;
                    break;
                case '}':
                    if (stack.pop() != '{')
                        return 0;
                    break;
                case '>':
                    if (stack.pop() != '<')
                        return 0;
                    break;
                case ')':
                    if (stack.pop() != '(')
                        return 0;
                    break;
                default:
                    stack.add(c);
            }
        }
        return 1;
    }
}
