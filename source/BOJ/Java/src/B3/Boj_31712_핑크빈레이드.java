package B3;

import java.io.*;
import java.util.StringTokenizer;

public class Boj_31712_핑크빈레이드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] skill = new int[3][2];

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            skill[i][0] = Integer.parseInt(st.nextToken());
            skill[i][1] = Integer.parseInt(st.nextToken());
        }

        int time = -1;
        int H = Integer.parseInt(br.readLine());

        while (H > 0) {
            time++;
            for (int i = 0; i < 3; i++) {
                if (time % skill[i][0] == 0) {
                    H -= skill[i][1];
                }
            }
        }

        bw.write(Integer.toString(time));
        bw.flush();
    }
}
