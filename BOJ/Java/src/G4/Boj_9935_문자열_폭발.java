package G4;

import java.io.*;
import java.util.Stack;

public class Boj_9935_문자열_폭발 {
    private static Stack<Character> stack;
    private static char[] boom;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] chars = br.readLine().toCharArray();
        boom = br.readLine().toCharArray();

        int last = boom[boom.length - 1];

        stack = new Stack<>();

        for (char c : chars) { // 입력된 문자열 검사
            if (stack.size() >= boom.length - 1 && c == last) { // 폭발 문자열의 마지막 문자와 같으면 폭발되는지 확인
                if (!boomCheck()) { // 안터졌으면 지금 문자 스택 넣기
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }

        if (stack.size() == 0) {
            bw.write("FRULA");
        } else {
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) sb.append(stack.pop());
            bw.write(sb.reverse().toString());
        }
        bw.flush();
    }

    private static boolean boomCheck() { // 폭발 검사 : 터지면 삭제
        char c;
        for (int i = boom.length - 2; i >= 0; i--) {
            if (stack.isEmpty()) {
                for (int j = i + 1; j < boom.length - 1; j++) {
                    stack.push(boom[j]);
                }
                return false;
            } else if ((c = stack.pop()) != boom[i]) { // 폭발 문자열 아님 : 복구
                stack.push(c);
                for (int j = i + 1; j < boom.length - 1; j++) {
                    stack.push(boom[j]);
                }
                return false;
            }
        }
        return true;
    }
}