package B2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2520 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] banjuk_list = {8, 8, 4, 1, 9};
        int[] toping_list = {1, 30, 25, 10};

        for (int i = 0; i < t; i++) {
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            float banjuk = 1000000;
            for (int j = 0; j < 5; j++) {
                float b = Float.parseFloat(st.nextToken());
                if (b / banjuk_list[j] < banjuk)
                    banjuk = b / banjuk_list[j];
            }
            banjuk = (int)(banjuk * 16);

            st = new StringTokenizer(br.readLine());
            int toping = 0;
            for (int j = 0; j < 4; j++) {
                int p = Integer.parseInt(st.nextToken());
                toping += p / toping_list[j];
            }
            System.out.println((int)(banjuk < toping ? banjuk:toping));
        }
    }
}
