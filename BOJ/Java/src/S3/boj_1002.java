package S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            double len = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));

            if (x1 == x2 && y1 == y2 && r1 == r2) { // 두 원이 일치함
                System.out.println(-1);
            }
            else if (len == r1 + r2 || len == Math.abs(r1 - r2)) { // 두 원이 하나의 접점을 가짐
                System.out.println(1);
            }
            else if (len < r1 + r2 && len > Math.abs(r1 - r2)) { // 두 원이 두 접점을 가짐
                System.out.println(2);
            }
            else { // 두 원이 만나지 않음
                System.out.println(0);
            }
        }
    }
}
