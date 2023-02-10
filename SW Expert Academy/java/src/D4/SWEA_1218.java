package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.Stack;

public class SWEA_1218 {
    public static void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        for (int t = 1; t <= 10; t++) {
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < n; i++) {
                char c = str.charAt(i);
                if (c == ']' || c == '}' || c == '>' || c == ')'){
                    char pop_char = stack.pop();
                }
            }


            System.out.println("#" + t + " " + answer);
        }
    }
}
