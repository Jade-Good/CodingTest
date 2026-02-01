package B1;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_27161_크레이지타임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int time = 1;
        int flag = 1;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            boolean isH = false;
            boolean isDone = false;

            if (st.nextToken().charAt(0) == 'H') isH = true;
            if (Integer.parseInt(st.nextToken()) == time) isDone = true;

            if (isDone && !isH) {
                sb.append(time).append(' ').append("YES\n");
            } else {
                sb.append(time).append(' ').append("NO\n");
                if (!isDone && isH) flag *= -1;
            }

            time += flag;
            if (time == 0) time = 12;
            else if (time == 13) time = 1;
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
