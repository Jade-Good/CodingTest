package G2;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_1918_후위_표기식 {
    private static class MyStack {
        int pointer;
        int[] stack;

        public MyStack(int pointer) {
            this.pointer = pointer;
            stack = new int[100];
        }

        public int push(int n) {
            stack[pointer++] = n;
            return pointer;
        }

        public int pop() {
            return stack[pointer--];
        }

        public boolean isEmpty() {
            return pointer == 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), ""); // A : 65, Z : 90
        
    }
}
