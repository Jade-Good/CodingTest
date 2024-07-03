package S5;

import java.io.*;

public class Boj_31799_평점_변환 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        char[] chars = br.readLine().toCharArray();

        String[] ss = new String[N];
        char sc = chars[0];
        int idx = 0;

        for (int i = 1; i < chars.length; i++) {
            if (c == '+' || c == '-') {
                ss[idx++] = "" + sc + c;
            } else if (c == '0') {
                ss[idx++] = "" + sc;
            } else {
                ss[idx++] = "" + sc;
                sc = c;
            }
        }

        if (idx < N - 1) {
            ss[idx] = "" + sc;
        }

    }
}
