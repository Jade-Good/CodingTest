package S4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_30890_드럼 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int lcm = lcm(X, Y); // X와 Y의 최소공배수

        for (int i = 1; i <= lcm; i++) {
            boolean left = (i % (lcm / X) == 0);  // 왼손이 연주해야 하는 타이밍
            boolean right = (i % (lcm / Y) == 0); // 오른손이 연주해야 하는 타이밍

            if (left && right) {
                sb.append(3);
            } else if (left) {
                sb.append(1);
            } else if (right) {
                sb.append(2);
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }

    // 최소공배수(Lowest Common Multiple) 계산
    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    // 최대공약수(Greatest Common Divisor) 계산
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
