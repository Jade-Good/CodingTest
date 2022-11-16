package B1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_6996 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String as = st.nextToken();
            String bs = st.nextToken();
            char a[] = as.toCharArray();
            char b[] = bs.toCharArray();
            Arrays.sort(a);
            Arrays.sort(b);
            String aa = new String(a);
            String bb = new String(b);

            if (aa.compareTo(bb) == 0){
                sb.append(as +" & "+ bs +" are anagrams.\n");
            }
            else {
                sb.append(as +" & "+ bs +" are NOT anagrams.\n");
            }
        }
        System.out.println(sb);
    }
}