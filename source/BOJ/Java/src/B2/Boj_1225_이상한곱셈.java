package B2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_1225_이상한곱셈 {
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

/*

1) A, B 하나씩 비교 = N^2

2) 숫자 카운팅 배열 비교 = N+N+10^2

 */