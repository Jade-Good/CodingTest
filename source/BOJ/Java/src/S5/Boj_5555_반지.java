package S5;

import java.io.*;

public class Boj_5555_반지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] target = br.readLine().toCharArray();
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 0; i < N; i++) {

            char[] now = br.readLine().toCharArray();

            for (int start = 0; start < now.length; start++) {

                boolean flag = true;

                for (int j = 0; j < target.length; j++) {
                    if (target[j] != now[(start + j) % now.length]) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    cnt++;
                    break;
                }

            }
        }

        bw.write(Integer.toString(cnt));
        bw.flush();
    }
}
