package B3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Stream;

public class Boj_17201_자석_체인 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = Stream.of(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        if (isChain(arr)) {
            bw.write("Yes");
        } else {
            bw.write("No");
        }
        bw.flush();
    }

    private static boolean isChain(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] + arr[i - 1] != 3) {
                return false;
            }
        }
        return true;
    }
}
