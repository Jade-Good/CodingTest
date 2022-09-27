package B3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1284 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String n = br.readLine();
            if (Integer.parseInt(n) == 0) break;
            int sum = n.length()+1;

            for (String s : n.split("")){
                if (s.compareTo("1") == 0) sum += 2;
                else if (s.compareTo("0") == 0) sum += 4;
                else sum += 3;
            }

            System.out.println(sum);
        }
    }
}
