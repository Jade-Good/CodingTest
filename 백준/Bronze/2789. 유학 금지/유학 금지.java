import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        char[] chars = "CAMBRIDGE".toCharArray();

        Set<Character> set = new HashSet<>();
        for (char c : chars) {
            set.add(c);
        }

        chars = br.readLine().toCharArray();
        for (char c : chars) {
            if (!set.contains(c)) {
                sb.append(c);
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
