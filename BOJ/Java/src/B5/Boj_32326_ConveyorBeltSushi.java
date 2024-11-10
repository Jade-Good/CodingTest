package B5;

import java.io.*;

public class Boj_32326_ConveyorBeltSushi {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int R = Integer.parseInt(br.readLine());
        int G = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());

        bw.write(Integer.toString(R * 3 + G * 4 + B * 5));
        bw.flush();
    }
}
