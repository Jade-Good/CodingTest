package S5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class boj_9733 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = {"Re","Pt","Cc","Ea","Tb","Cm","Ex"};
        HashMap<String, Integer> map = new HashMap<>();
        for (String a : arr)
            map.put(a,0);

        String input = "";
        int count = 0;
        while ((input=br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                String s = st.nextToken();
                if (map.containsKey(s))
                    map.put(s, map.get(s)+1);
                count++;
            }
        }

        for (String a : arr) {
            double result = 0.0;
            if (map.get(a)!=0)
                result = (double)map.get(a)/count;
            System.out.printf("%s %d %.2f\n", a, map.get(a), result);
        }
        System.out.printf("Total %d 1.00\n", count);
    }
}
