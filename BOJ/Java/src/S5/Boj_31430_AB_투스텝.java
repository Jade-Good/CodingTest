package S5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_31430_AB_투스텝 {
    private static final int LEN = 13;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int order = Integer.parseInt(br.readLine());

        if (order == 1) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            bw.write(encoding(Long.parseLong(st.nextToken()) + Long.parseLong(st.nextToken())));
        } else {
            bw.write(decoding(br.readLine()));
        }
        bw.flush();
    }

    private static String encoding(long sum) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < LEN; i++) {
            sb.append((char) (sum % 26 + 'a'));
            sum /= 26;
        }
        return sb.toString();
    }

    private static String decoding(String str13) {
        long sum = 0;
        for (int i = 0; i < LEN; i++) {
            sum += (str13.charAt(i) - 'a') * (long) Math.pow(26, i);
        }
        return Long.toString(sum);
    }
}
