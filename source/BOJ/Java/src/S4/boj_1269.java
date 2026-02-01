package S4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class boj_1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> set_A = new HashSet<>();
        HashSet<String> set_B = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            set_A.add(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            set_B.add(st.nextToken());
        }

        HashSet<String> set_retain = new HashSet<>();
        set_retain.addAll(set_A);
        set_retain.retainAll(set_B);

        set_A.removeAll(set_retain);
        set_B.removeAll(set_retain);

        System.out.println(set_A.size()+set_B.size());
    }
}
