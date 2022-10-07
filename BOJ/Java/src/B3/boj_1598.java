package B3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1598 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());

        int x1 = (n1 - 1) / 4 + 1;
        int x2 = (n2 - 1) / 4 + 1;
        int y1 = (n1 - 1) % 4;
        int y2 = (n2 - 1) % 4;
        int distance = (Math.abs(x2 - x1) + Math.abs(y2 - y1));

        System.out.println(distance);
    }
}
