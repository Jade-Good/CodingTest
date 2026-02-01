package S2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj_18890 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[][] arr = new Integer[n][3];
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1
        for (int i = 0; i < n; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = i;
        }

        // 2
//        Arrays.sort(arr, (o1, o2) -> o1[0] - o1[0]); // 람다식 표현
        Arrays.sort(arr, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        // 3
        int count = 0;
        arr[0][2] = count;
        for (int i = 1; i < n; i++) {
            if (!(arr[i][0].equals(arr[i-1][0])))
                count++;
            arr[i][2] = count;
        }

        // 4
        Arrays.sort(arr, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i][2] + " ");
        }
        System.out.println(sb);
    }
}
