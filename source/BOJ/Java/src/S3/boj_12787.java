package S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class boj_12787 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            if (m == 1){
                String input = st.nextToken();
                String[] arr = input.split("[.]");
                String binary = "";
                for (String n : arr) {
                    binary += String.format("%8s", Integer.toBinaryString(Integer.parseInt(n))).replaceAll(" ", "0");
                }
                System.out.println(new BigInteger(binary,2));
            }
            else {
                String binary = String.format("%64s", (new BigInteger(st.nextToken())).toString(2)).replaceAll(" ", "0");
                String answer = "";
                int j = 0;
                for (j = binary.length(); j > 8; j-=8) {
                    answer = "." + Long.parseLong(binary.substring(j-8,j),2) + answer;
                }
                answer = Long.parseLong(binary.substring(0,j),2) + answer;
                System.out.println(answer);
            }
        }
    }
}
