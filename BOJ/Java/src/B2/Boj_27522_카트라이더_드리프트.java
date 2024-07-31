package B2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj_27522_카트라이더_드리프트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] points = {10, 8, 6, 5, 4, 3, 2, 1};
        String[][] record = new String[8][2];
        for (int i = 0; i < 8; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            record[i][0] = st.nextToken();
            record[i][1] = st.nextToken();
        }

        Arrays.sort(record, Comparator.comparing(a -> a[0]));

        int red = 0;
        int blue = 0;

        for (int i = 0; i < 8; i++) {
            if (record[i][1].equals("R")) {
                red += points[i];
            } else {
                blue += points[i];
            }
        }

        if (red == blue) {
            bw.write(record[0][1].equals("R") ? "Red" : "Blue");
        } else if (red > blue) {
            bw.write("Red");
        } else {
            bw.write("Blue");
        }
        bw.flush();
    }
}
