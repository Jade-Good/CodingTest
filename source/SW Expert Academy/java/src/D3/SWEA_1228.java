package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_1228 {
    public static void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        for (int t = 1; t <= 10; t++) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<Integer> amho = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                amho.add(Integer.parseInt(st.nextToken()));
            }

            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                st.nextToken();
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                for (int j = 0; j < y; j++) {
                    amho.add(x++, Integer.parseInt(st.nextToken()));
                }
            }

            System.out.print("#" + t);
            for (int i = 0; i < 10; i++) {
                System.out.print(" " + amho.get(i));
            }
            System.out.println();
        }
    }
}
