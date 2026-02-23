import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String S;

        while ((S = br.readLine()) != null && !S.isEmpty()) {
            sb.append(S);
        }

        int sum = Arrays.stream(sb.toString().split(",")).mapToInt(Integer::parseInt).sum();

        bw.write(Integer.toString(sum));
        bw.flush();
    }
}
