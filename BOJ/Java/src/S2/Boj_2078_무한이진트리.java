package S2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_2078_무한이진트리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int left = 0;
        int right = 0;

        while (A > 1 || B > 1) {
            if (A > B) {
                left++;
                A -= B;
            } else {
                right++;
                B -= A;
            }
        }

        sb.append(left).append(' ').append(right);
        bw.write(sb.toString());
        bw.flush();
    }
}
