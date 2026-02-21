import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] A = st.nextToken().toCharArray();
        char[] B = st.nextToken().toCharArray();
        int[] cntA = new int[11];
        int[] cntB = new int[11];
        long sum = 0;

        for (char c : A) {
            cntA[c - '0']++;
        }
        for (char c : B) {
            cntB[c - '0']++;
        }

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                sum += (long) i * j * cntA[i] * cntB[j];
            }
        }

        bw.write(Long.toString(sum));
        bw.flush();
    }
}