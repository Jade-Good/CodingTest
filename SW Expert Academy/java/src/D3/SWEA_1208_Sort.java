package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1208_Sort {
    static int max_value, max_idx, min_value = 100, min_idx;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // TestCase
        for (int t = 1; t <= 10; t++) {
            long start = System.nanoTime();
            // Input
            arr = new int[100];
            int dump = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());;
            for (int i = 0; i < 100; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            // Recursion
            System.out.println("#" + t + " " + recursion(dump));
            long end = System.nanoTime();
            System.out.println("time : " + (end - start)/1000 + "ms");
        }
    }
    private static int recursion(int dump) {
        Arrays.sort(arr);
        if (dump == 0 || arr[99] - arr[0] <= 1) {
            return arr[99] - arr[0];
        }
        else {
            arr[99]--;
            arr[0]++;
            return recursion(dump - 1);
        }
    }
}

/*

#1 13
time : 3230073ms
#2 32
time : 524ms
#3 54
time : 893ms
#4 25
time : 1574ms
#5 87
time : 125ms
#6 14
time : 653ms
#7 39
time : 534ms
#8 26
time : 474ms
#9 13
time : 609ms
#10 29
time : 533ms

종료 코드 0(으)로 완료된 프로세스


 */