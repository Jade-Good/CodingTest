
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = -8;

        for (int i = 0; i < N; i++) {
            sum += Integer.parseInt(st.nextToken()) + 8;
        }

        sb.append(sum / 24).append(' ').append(sum % 24);
        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
