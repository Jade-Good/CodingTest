package D0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_5658_보물상자_비밀번호 {
    //        public static void main(String[] args) throws IOException{
    public static void test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            String[] ss = br.readLine().split("");
            ArrayList<String> box = new ArrayList<>(Arrays.asList(ss).subList(0, N));

            TreeSet<String> ts = new TreeSet<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 4; j++) {
                    StringBuilder pw = new StringBuilder();
                    for (int k = 0; k < N/4; k++) {
                        pw.append(box.get(j * N/4 + k));
                    }
                    ts.add(pw.toString());
                }
                box.add(0, box.remove(box.size()-1));
            }
            Iterator iter = ts.iterator();
            for (int i = 0; i < ts.size()-K; i++) {
                iter.next();
            }
            System.out.println("#" + t + " " + Integer.parseInt(iter.next().toString(), 16));
        }
    }
}
