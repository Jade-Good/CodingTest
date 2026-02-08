package B2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_32860_수수수수퍼노바 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        sb.append('S').append('N').append(' ').append(N);

        if (M <= 26) {
            sb.append((char) (M + 'A' - 1));
        } else {
            M -= 27;
            sb.append((char) ((M / 26) + 'a')).append((char) ((M % 26) + 'a'));
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
/*

1 1     1 26    1 27    1 51    1 52    1 53
1A      1Z      1aa     1ay     1az     1ba

26 < x < 26.5

52 % y = 26
53 % y = 1
 */