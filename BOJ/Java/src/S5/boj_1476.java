package S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int ee = 1, ss = 1, mm = 1, answer = 1;
        while (!(ee == e && ss == s && mm == m) && answer < 10000){
            answer++;
            if (++ee == 16) ee = 1;
            if (++ss == 29) ss = 1;
            if (++mm == 20) mm = 1;
        }
        System.out.println(answer);
    }
}