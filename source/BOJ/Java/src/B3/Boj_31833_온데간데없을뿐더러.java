package B3;

import java.io.*;

public class Boj_31833_온데간데없을뿐더러 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        char[] A = br.readLine().replaceAll(" ", "").toCharArray();
        char[] B = br.readLine().replaceAll(" ", "").toCharArray();
        char[] result = A.length < B.length ? A : B;

        if (A.length == B.length) {
            for (int i = 0; i < A.length; i++) {
                if (A[i] < B[i]) {
                    result = A;
                    break;
                } else if (A[i] > B[i]) {
                    result = B;
                    break;
                }
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();

    }
}
