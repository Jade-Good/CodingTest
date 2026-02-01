package S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_1384 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int count = 0;
        while (n > 0){
            String name[] = new String[n];
            ArrayList<Integer>[] nasty = new ArrayList[n];
            for (int i = 0; i < n; i++)
                nasty[i] = new ArrayList<Integer>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                name[i] = st.nextToken();
                for (int j = 1; j <= n-1; j++){
                    String write = st.nextToken();
                    if (write.compareTo("N") == 0){
                        nasty[i].add(((n+(i-j))%n));
                    }
                }
            }

            System.out.println("Group " + ++count);
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < nasty[i].size(); j++){
                    System.out.println(name[nasty[i].get(j)] + " was nasty about " + name[i]);
                    flag = false;
                }
            }
            if (flag)
                System.out.println("Nobody was nasty");

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if (n>0)
                System.out.println("");
        }
    }
}
