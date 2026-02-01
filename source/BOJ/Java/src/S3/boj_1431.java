package S3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class boj_1431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) arr[i] = br.readLine();

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int len1 = o1.length();
                int len2 = o2.length();
                if (len1 != len2)
                    return len1 - len2;
                else {
                    int sum1 = 0, sum2 = 0;
                    for (int i = 0; i < len1; i++){
                        if (o1.charAt(i) >= '0' && o1.charAt(i) <= '9')
                            sum1 += o1.charAt(i) - '0';
                        if (o2.charAt(i) >= '0' && o2.charAt(i) <= '9')
                            sum2 += o2.charAt(i) - '0';
                    }

                    if (sum1 != sum2)
                        return sum1 - sum2;
                    else
                        return o1.compareTo(o2);
                }
            }
        });

        for (String s : arr) {
            System.out.println(s);
        }
    }
}
