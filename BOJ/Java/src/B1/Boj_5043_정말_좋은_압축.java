package B1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_5043_정말_좋은_압축 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long sum = 1;

        while (B > 0) {
            sum += 1L << B--;
        }

        bw.write(sum >= N ? "yes" : "no");
        bw.flush();
    }
}
/*
B   k
0   1
1   3
2   7
 */