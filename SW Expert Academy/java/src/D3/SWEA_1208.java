package D3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1208 {
    static int max_value, max_idx, min_value = 100, min_idx;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // TestCase
        for (int t = 1; t <= 10; t++) {
            // Input
            arr = new int[100];
            int dump = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());;
            for (int i = 0; i < 100; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            // Recursion
            System.out.println("#" + t + " " + recursion(dump));
        }
    }
    private static int recursion(int dump) {
        setMM(); // find max, min
        if (dump == 0 || max_value - min_value <= 1) {
            return max_value - min_value;
        }
        else {
            arr[max_idx]--;
            max_value--;
            arr[min_idx]++;
            min_value++;
            return recursion(dump - 1);
        }
    }

    private static void setMM(){
        for (int i = 0; i < 100; i++) {
            if (arr[i] > max_value) {
                max_value = arr[i];
                max_idx = i;
            }
            if (arr[i] < min_value) {
                min_value = arr[i];
                min_idx = i;
            }
        }
    }
}

/*

#1 13
time : 1014846ms
#2 32
time : 406ms
#3 54
time : 260ms
#4 25
time : 397ms
#5 87
time : 76ms
#6 14
time : 480ms
#7 39
time : 101ms
#8 26
time : 97ms
#9 13
time : 111ms
#10 29
time : 102ms

종료 코드 0(으)로 완료된 프로세스


 */