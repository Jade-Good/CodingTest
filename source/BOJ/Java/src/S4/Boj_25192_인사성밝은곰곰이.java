package S4;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Boj_25192_인사성밝은곰곰이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Set<String> set = null;
        int cnt = 0;

        for (int i = 0; i < N; i++) {

            String name = br.readLine();

            if (name.equals("ENTER")) {
                set = new HashSet<>();
            } else if (!set.contains(name)) {
                set.add(name);
                cnt++;
            }
        }

        bw.write(Integer.toString(cnt));
        bw.flush();
    }
}
