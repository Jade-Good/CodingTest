package B4;

import java.io.*;

public class Boj_6810_ISBN {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum = 91;
        sum += Integer.parseInt(br.readLine());
        sum += Integer.parseInt(br.readLine()) * 3;
        sum += Integer.parseInt(br.readLine());

        bw.write("The 1-3-sum is " + sum);
        bw.flush();
    }
}
