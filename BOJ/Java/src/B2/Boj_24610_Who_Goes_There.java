package B2;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_24610_Who_Goes_There {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] schools = new int[m];
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += schools[i] = Integer.parseInt(br.readLine());
        }

        int[] answer = new int[m];
        int idx = 0;
        while (n > 0 && sum > 0) {
            if (answer[idx] < schools[idx]) {
                answer[idx]++;
                n--;
                sum--;
            }
            idx = (idx + 1) % m;
        }

        for (int i = 0; i < m; i++) {
            sb.append(answer[i]).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
