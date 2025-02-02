package B4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_13580_Andandonotempo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        if (arr[0] == arr[1] || arr[1] == arr[2] || arr[1] + arr[0] == arr[2]) {
            bw.write("S");
        } else {
            bw.write("N");
        }
        bw.flush();
    }
}
