package G2;

import java.io.*;

public class Boj_1918_후위_표기식 {
    private static class MyStack {
        private int pointer;
        private char[] stack;

        public MyStack() {
            this.pointer = 0;
            stack = new char[100];
        }

        public void push(char c) {
            stack[pointer++] = c;
        }

        public char pop() {
            return stack[--pointer];
        }

        public boolean isEmpty() {
            return pointer == 0;
        }

        public char peek() {
            if (pointer == 0) return '\0';
            else return stack[pointer - 1];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        char[] input = br.readLine().toCharArray(); // A : 65, Z : 90

        MyStack stack = new MyStack();

        for (char c : input) {
            if (c >= 65 && c <= 90) // 입력 문자가 알파벳일 경우
                sb.append(c);
            else { // 입력 문자가 연산자일 경우
                if (c == '+' || c == '-') { // '+' or '-'
                    if (stack.peek() == '*' || stack.peek() == '/') {
                        while (!stack.isEmpty() && stack.peek() != '(') {
                            sb.append(stack.pop());
                        }
                    } else if (stack.peek() == '+' || stack.peek() == '-')
                        sb.append(stack.pop());
                    stack.push(c);
                } else if (c == '*' || c == '/') { // '*' or '/'
                    if (stack.peek() == '*' || stack.peek() == '/') {
                        sb.append(stack.pop());
                    }
                    stack.push(c);
                } else if (c == '(') { // '('
                    stack.push(c);
                } else { // ')'
                    while (!stack.isEmpty()) {
                        char p = stack.pop();
                        if (p == '(') {
                            break;
                        }
                        sb.append(p);
                    }
                }
            }
        }
        while (!stack.isEmpty())
            sb.append(stack.pop());
        bw.write(sb.toString());
        bw.flush();
    }
}
