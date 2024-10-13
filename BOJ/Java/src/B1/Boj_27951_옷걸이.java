package B1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj_27951_옷걸이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int onlyUp = 0;
        int olnyDown = 0;
        int UpDown = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            switch (A[i]) {
                case 1:
                    onlyUp++;
                    break;
                case 2:
                    olnyDown++;
                    break;
                case 3:
                    UpDown++;
            }
        }

        st = new StringTokenizer(br.readLine());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        if (Math.max(U - onlyUp, 0) + Math.max(D - olnyDown, 0) > UpDown) { // 위아래 부족한 옷걸이 수의 합이 3의 갯수보다 크면 못걸음
            bw.write("NO");
            bw.flush();
            return;
        } else {
            sb.append("YES\n");
        }

        char[] result = new char[N];

        for (int i = 0; i < N; i++) {
            if (A[i] == 1) {
                U--;
                result[i] = 'U';
            } else if (A[i] == 2) {
                D--;
                result[i] = 'D';
            }
        }

        for (int i = 0; i < N; i++) {
            if (A[i] != 3) {
                continue;
            }
            if (U > 0) {
                U--;
                result[i] = 'U';
            } else {
                D--;
                result[i] = 'D';
            }
        }

        sb.append(new String(result));

        bw.write(sb.toString());
        bw.flush();
    }
}
